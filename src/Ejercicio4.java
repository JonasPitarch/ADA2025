import java.io.File;
import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {

        // Creem instàncies de la classe File amb les rutes relatives de les carpetes a crear
        File lesMeuesCoses = new File("Documentos/Les Meues Coses");
        File alfabet = new File("Documentos/Alfabet");

        // Crea les carpetes amb mkdir() i mostra si s'han creat correctament

        crearcarpetas(lesMeuesCoses);
        crearcarpetas(alfabet);

        // Anem a moure les carpetes. Primer, crea objectes File amb les rutes origen i destí
        File fotoOrigen = new File("Documentos/Fotografias");
        File fotoDesti = new File("Documentos/Les Meues Coses/Fotografias");

        File llibreOrigen = new File("Documentos/Libros");
        File llibreDesti = new File("Documentos/Les Meues Coses/Libros");

        // Mou la carpeta Fotografias dins de Les Meues Coses i mostra si ha funcionat
        fotoOrigen.renameTo(fotoDesti);

        // Mou la carpeta Libros dins de Les Meues Coses i mostra si ha funcionat
        llibreOrigen.renameTo(llibreDesti);

        // Crea dins de 'Alfabet' una carpeta per a cada lletra (A..Z) utilitzant els codis ASCII

        File alf = new File("Documentos/Alfabet/");
        for (int i = 65; i < 91; i++) {
            char letra = (char) i;
            File n = new File("Documentos/Alfabet/" + letra);
            crearcarpetas(n);
        }

        // Llista el contingut final de 'Alfabet' amb listFiles() i mostra per pantalla els noms de les carpetes creades
        lista(alfabet);
    } // Del main()

    static void crearcarpetas(File x){
        if (x.mkdir()){
            System.out.println("La carpeta a sido creada");
        }
        else {
            System.out.println("ERROR : la carpeta a sido creada anteriormente");
        }
    }
    static void lista(File x){
        File[] lista = x.listFiles();
        Arrays.sort(lista);
        for(File f : lista){
            if(f.isDirectory()){
                System.out.println("[D] " +  f.getName());
            }
            if (f.isFile()){
                System.out.println("[A] " + f.getName());
            }
        }
    }
}
