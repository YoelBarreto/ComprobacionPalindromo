package palindromoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PalindromoServer {

    public static void main(String[] args) {
        int port = 9876;
        try {
            // Socket para aceptar conexiones.
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor para cálculo de palíndromos iniciado en el puerto " + port + ".");
            
            // Recibir y atender peticiones indefinidamente.
            while (true) {
                // Aceptar una conexión.
                Socket conexion = serverSocket.accept();
                
                // Crear y lanzar hilo para atender la petición.
                Thread hilo = new Thread(new CalculoPalindromo(conexion));
                hilo.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
