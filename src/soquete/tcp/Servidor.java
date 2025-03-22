package soquete.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Servidor {
    public static void main(String[] args) {
        int porta = 6789;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor TCP aguardando conexões na porta " + porta + "...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)) {

                    String region = entrada.readLine().trim();
                    String response;

                    try {
                        response = ZonedDateTime.now(ZoneId.of(region)).toString();
                    } catch (Exception e) {
                        response = "Região inválida!";
                    }

                    saida.println(response);
                } catch (IOException e) {
                    System.out.println("Erro ao processar a solicitação do cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
