import java.io.File;
import java.io.FileNotFoundException;

public class Minifilemanager {

    //Ruta actual
    private File currentPath;

    //Constructor
    public Minifilemanager(){
        currentPath = new File(System.getProperty("user.dir"));
    }

    public void pwd (File currentPath){
        System.out.println(currentPath);
    }

    void cd (File currentPath){
        if (currentPath.equals("..")){

        }
    }
    void mv (File currentPath, File n){
        if (currentPath.exists()){
            currentPath.renameTo(n);
        }
        else {
            System.out.println("ERROR: Revisa si la carpeta existe");
        }
    }

    void mkdir(File x){
        if (x.exists()){
            System.out.println("ERROR: El directorio ya existe");
        }
        else {
            x.mkdir();
        }
    }
    void rm(File x) throws FileNotFoundException {
        if (!x.exists()){
            throw new FileNotFoundException("ERROR");
        }
        x.delete();
        System.out.println("Eliminado");
    }

    void ls(File x){

    }
    void ll(File x){

    }

    public void help() {
        System.out.println();
        System.out.println("pwd                      muestra el directorio actual");
        System.out.println("cd <dir>                 cambia al directorio especificado, '..' para volver a la carpeta anterior");
        System.out.println("ls                       muestra los archivos y carpetas del directorio actual");
        System.out.println("ll                       muestra los archivos y carpetas del directorio actual con info extendida");
        System.out.println("mkdir <dir>              crea el directorio especificado");
        System.out.println("rm <file>                borra el archivo, o carpeta si está vacía");
        System.out.println("mv <fileOri> <fileDes>   mueve el archivo o carpeta de origen a destino");
        System.out.println("help                     muestra información sobre las ordenes integradas");
        System.out.println("exit                     salir del intérprete de ordenes");
        System.out.println();
    }
}