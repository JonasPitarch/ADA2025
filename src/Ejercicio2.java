import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner teclat = new Scanner(System.in);
        String ruta = ".";
        boolean masinfo = false;
        while (!ruta.equals("")) {
            System.out.println("Dime la ruta a utilizar");
            ruta = teclat.nextLine();
            System.out.println("Dime si quieres mas informacion");
            String m = teclat.nextLine();
            if (m.equalsIgnoreCase("Si")){
                masinfo = true;
            }else if (m.equalsIgnoreCase("No")){
                masinfo = false;
            }
            try {
                File a = new File(ruta);
                mostrarRuta(a, masinfo);
            }
            catch (FileNotFoundException e) {
                System.out.println("Gracias por usar el terminal");
            }

        }
    }

    static void mostrarRuta(File x , boolean masinfo) throws FileNotFoundException {
        if(!x.exists()){
            throw new FileNotFoundException("ERROR - Ruta invalida");
        }
        File [] lista = x.listFiles();
        if (masinfo != true){
            for (File l : lista){
                if (l.isDirectory()){
                    System.out.println("[D] " + l.getName());
                }
                if (l.isFile()){
                    System.out.println("[A] " + l.getName());
                }
            }
        }
        if (masinfo == true){
            for (File l : lista){
                if (l.isDirectory()){
                    System.out.println("[D] " + l.getName() + " la ultima modificacion es el " + l.lastModified() + " el " +
                            "tamaño es " + l.length() + " bytes" );
                }
            }
        }
    }
}