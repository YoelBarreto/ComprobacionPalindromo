package palindromoserver;

import static palindromoserver.CalculoPalindromo.Erroneo;
import static palindromoserver.CalculoPalindromo.Correcto;
import static palindromoserver.CalculoPalindromo.Salir;

public class Calculador {
    public static String palindromo(String cadena) {
        String palabra = "";
        for (int i=cadena.length(); i < cadena.length(); i--) {
            palabra += cadena.codePointAt(i);
        }
        palabra.toUpperCase();
        if (palabra == cadena) {
            return Correcto(palabra);
        } else if (cadena == "FIN"){
            return Salir();
        }else {
            return Erroneo(palabra);
        }
    }
}
