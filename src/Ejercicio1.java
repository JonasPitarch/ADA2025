import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner teclat = new Scanner(System.in);
        String ruta = ".";
        while (!ruta.equals("")) {
            System.out.println("Dime la ruta a utilizar");
            ruta = teclat.nextLine();
            try {
                File a = new File(ruta);
                mostrarRuta(a);
            }
            catch (FileNotFoundException e) {
                System.out.println("Gracias por usar el terminal");
            }

        }
    }

    static void mostrarRuta(File x) throws FileNotFoundException {
        if(!x.exists()){
            throw new FileNotFoundException("ERROR - Ruta invalida");
        }
        mostrartipo(x);
    }

    static void mostrartipo(File x){
          File [] lista = x.listFiles();
          for (File l : lista){
              if (l.isDirectory()){
                  System.out.println("[D] " + l.getName());
              }
              if (l.isFile()){
                  System.out.println("[A] " + l.getName());
              }
          }
    }
}