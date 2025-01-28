package palindromoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static palindromoserver.Calculador.palindromo;

public class CalculoPalindromo implements Runnable {
    // Propiedades.
    BufferedReader bfr;
    PrintWriter pw;
    Socket socket;
    Boolean salir = false;
    
    // Constructor.
    public CalculoPalindromo(Socket socket) {
        this.socket = socket;
    }
    
    // Método run().
    @Override
    public void run() {
        try {
            System.out.println("Cliente conectado: " + socket.getInetAddress());
            
            // Crear los streams.
            bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            
            // Recibir el número de líneas que se van a procesar.
            int numeroLineas = Integer.parseInt(bfr.readLine());
            String linea;
            for (int i=0; i< numeroLineas; i++) {
                linea = bfr.readLine();
                // Enviar el resultado.
                pw.println(palindromo(linea));
            }
            if (salir == true) {
                pw.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static String Erroneo(String palabra) {
        return palabra + "no es un palindromo.";
    }
    
    public static String Correcto(String palabra) {
        return palabra + "es un palindromo.";
    }
    
    public static void Salir() {
        salir = true;
        return salir;
    }
}
