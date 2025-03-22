package soquete.tcpthreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Cliente {

    public static void main(String[] args) {
        soquete.tcp.Cliente.main(new String[0]);
    }

    static class ClienteHandler implements Runnable {
        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                System.out.println("Erro ao processar requisição: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}
