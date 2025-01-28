package palindromoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PalindromoClient {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        
        try {
            // Conexión al servidor.
            Socket conexion = new Socket(host, port);
            System.out.println("Conectado al servidor" + host + " en puerto" + port + ".");
            
            // Streams para enviar y recibir mensajes.
            BufferedReader input = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter output = new PrintWriter(conexion.getOutputStream(), true);
            
            // Comunicación con el servidor.
            Scanner s = new Scanner(System.in);
            
            // output.println(2);
            // output.println("2");
            // output.println("3");
            // output.flush();
            
            // Recepción.
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            
            // Cerrar los streams.
            input.close();
            input.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
