package ru.job4j.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write(("HTTP/1.1 200 OK" + System.lineSeparator() + System.lineSeparator()).getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        String[] values = str.split("=");
                        if ("?msg".equals(values[0])) {
                            if ("Buy".equals(values[1])) {
                                server.isClosed();
                            }
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
