package com.example.javasocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClockClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            int port = 12345;

            while (true) {
                Socket socket = new Socket(serverAddress, port);
                BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

                serverOut.println("time");

                String currentTime = serverIn.readLine();
                System.out.println("Thời gian hiện tại: " + currentTime);

                Thread.sleep(1000);

                socket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
