package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    while (in.ready()) {
                        String str = in.readLine();
                        System.out.println(str);
                        String[] values = str.split(" ");
                        if ("GET".equals(values[0])) {
                            switch (values[1]) {
                                case "/?msg=Exit" -> server.close();
                                case "/?msg=Hello" -> out.write("Hello\r\n\r\n".getBytes());
                                default -> out.write("What\r\n\r\n".getBytes());
                            }
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
