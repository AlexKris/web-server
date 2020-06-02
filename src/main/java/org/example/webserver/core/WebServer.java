package org.example.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private ServerSocket server;

    public WebServer() {
        try {
            this.server = new ServerSocket(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Socket socket = this.server.accept();
            ClientHandler handler = new ClientHandler(socket);
            Thread t = new Thread(handler);
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServer server = new WebServer();
        server.start();
    }
}
