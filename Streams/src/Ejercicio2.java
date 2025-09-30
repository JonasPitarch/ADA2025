import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        String filePath = "Documentos/pi-million.txt";


        long total = 0;
        long suma = 0;
        int min = 255;
        int max = 0;

        byte[] buffer = new byte[8192];

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            int n;
            while ((n = in.read(buffer)) != -1) {
                for (int i = 0; i < n; i++) {
                    int valor = buffer[i] & 0xFF;
                    if (valor < min){
                        min = valor;
                    }
                    if (valor > max){
                        max = valor;
                    }
                    suma += valor;
                    total++;
                }
            }
            double mitjana = suma/total;
            System.out.println("Total de bytes: " + total);
            System.out.println("Valor mínim: " + min);
            System.out.println("Valor màxim: " + max);
            System.out.println("Mitjana: " + mitjana);
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

}
