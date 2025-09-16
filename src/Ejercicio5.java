import java.io.File;
import java.io.FileNotFoundException;

public class Ejercicio5 {
    public static void main(String[] args) {
        File fotos = new File("Documentos/Fotografias");
        File libros = new File("Documentos/Libros");
        File documentos = new File("Documentos");
        try {
            borrar(fotos);
            borrar(libros);
            borrar(documentos);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void borrar(File x) throws FileNotFoundException {
        if (x.exists()){
            if (x.isFile()){
                x.delete();
                System.out.println("Archivo eliminado");
            }
            if (x.isDirectory()){
                File[] f = x.listFiles();
                for (File l : f){
                    l.delete();
                }
                x.delete();
                System.out.println("Directorio eliminado");
            }
        }else {
            throw new FileNotFoundException("ERROR quieres borrar algo inexistente");
        }
    }
}
