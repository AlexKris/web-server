package org.example.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("一个客户端连接了！");

        try {
            InputStream in = this.socket.getInputStream();
            boolean var2 = true;

            int d;
            while ((d = in.read()) != -1) {
                System.out.print((char) d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
