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
        System.out.println(currentPath.getAbsolutePath());
    }

    public void cd(String destino) {
        if (destino.equals("..")) {
            File parent = currentPath.getParentFile();
            if (parent != null) {
                currentPath = parent;
            } else {
                System.out.println("Ya estás en la raíz, no puedes subir más.");
            }
        } else {
            File nuevoDir = new File(currentPath, destino);
            if (nuevoDir.exists() && nuevoDir.isDirectory()) {
                currentPath = nuevoDir;
            } else {
                System.out.println("El directorio no existe: " + destino);
            }
        }
    }

    public void mv(String origen, String destino) {
        File archivoOrigen = new File(currentPath, origen);
        File archivoDestino = new File(currentPath, destino);
        if (!archivoOrigen.exists()) {
            System.out.println("ERROR: El archivo o directorio origen no existe");
            return;
        }
        if (archivoDestino.exists()) {
            System.out.println("ERROR: El destino ya existe");
            return;
        }
        if (archivoOrigen.renameTo(archivoDestino)) {
            System.out.println("Movido/Renombrado con éxito");
        } else {
            System.out.println("ERROR: No se pudo mover/renombrar");
        }
    }


    public void mkdir(String nombre) {
        File nuevoDir = new File(currentPath, nombre);
        if (nuevoDir.exists()) {
            System.out.println("ERROR: El directorio ya existe");
        } else if (nuevoDir.mkdir()) {
            System.out.println("Directorio creado: " + nuevoDir.getAbsolutePath());
        } else {
            System.out.println("ERROR: No se pudo crear el directorio");
        }
    }

    void rm(File x) throws FileNotFoundException {
        if (!x.exists()){
            throw new FileNotFoundException("ERROR");
        }
        x.delete();
        System.out.println("Eliminado");
    }

    void ls(File currentPath){
        File [] lista = currentPath.listFiles();
        for (File l : lista){
            if (l.isDirectory()){
                System.out.println("[D] " + l.getName());
            }
            if (l.isFile()){
                System.out.println("[A] " + l.getName());
            }
        }
    }
    void ll(File x){
        File [] lista = x.listFiles();
        for (File l : lista){
            if (l.isDirectory()){
                System.out.println("[D] " + l.getName() + " la ultima modificacion es el " + l.lastModified() + " el " +
                        "tamaño es " + l.length() + " bytes" );
            }
        }
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