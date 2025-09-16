import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class Ejercicio3 {


    /* **************************
     * Reanomenem les carpetes  *
     * **************************/



// Creem dos objectes de tipus File on assignem la ruta d'origen i la ruta de destí (PER A LA CARPETA DOCUMENTOS)

    public static void main (String args[]) {

        File docOrigen = new File("Documentos");
        File docDesti =new File("DOCS");

// Comprovem que la carpeta DOCUMENTOS està creada; simplement és per acotar errors

        if(!docOrigen.exists())
            System.out.println("COMPROVA QUE LA CARPETA DOCUMENTOS ESTÀ CREADA I LA RUTA ÉS CORRECTA");

// Reanomenem la carpeta Documentos

        docOrigen.renameTo(docDesti);

// Creem dos objectes de tipus File on assignem la ruta d'origen i la ruta de destí (PER A LA CARPETA FOTOGRAFIAS) i canviem el nom
        File Fotografias = new File("/home/jonpitsaf/IdeaProjects/ejercicio1/DOCS/Fotografias");
        File Fotografiasnom2= new File("/home/jonpitsaf/IdeaProjects/ejercicio1/DOCS/FOTOS");
        Fotografias.renameTo(Fotografiasnom2);



// Creem dos objectes de tipus File on assignem la ruta d'origen i la ruta de destí (PER A LA CARPETA LIBROS) i canviem el nom

        File Libros = new File("/home/jonpitsaf/IdeaProjects/ejercicio1/DOCS/Libros");
        File libros2 = new File("/home/jonpitsaf/IdeaProjects/ejercicio1/DOCS/LECTURES");

        Libros.renameTo(libros2);

        /* **********************************************************
         *  Llevem les extensions en LECTURES (REANOMENANT ELS ARXIUS)
         ********************************************************** */

        System.out.println("Llistat d'arxius de " + libros2 + " abans de llevar les extensions:");
        imprimirLlistaArxius(libros2);
        System.out.println("");

        // Reanomenem els arxius, llevant les extensions
        llevarExtensionsArxius(libros2);

        // DESPRÉS d'eliminar les extensions, imprimim la llista d'arxius ordenada
        System.out.println("Llistat d'arxius de " + libros2 + " després de llevar les extensions:");
        imprimirLlistaArxius(libros2);
        System.out.println("");

    }

    public static void llevarExtensionsArxius(File ruta) {
        for (File f : ruta.listFiles()) {
            String[] TrocetsArxius = f.getName().split("\\.");
            File fDesti = new File(f.getParent() + "/" + TrocetsArxius[0]);
            f.renameTo(fDesti);
        }
    }

    // Imprimeix la llista d'arxius ordenada
    public static void imprimirLlistaArxius(File ruta) {
        File[] llista = ruta.listFiles();
        // Ordena la llista alfabèticament
        Arrays.sort(llista);

        // Recorre la llista mostrant el nom dels arxius
        for (File f : llista) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }

}
