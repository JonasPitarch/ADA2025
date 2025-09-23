import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import static java.io.File.separator;

public class Minifilemanager {

    private File currentPath;

    public Minifilemanager(){
        currentPath = new File(System.getProperty("user.dir"));
    }

    public void pwd (){
        System.out.println(currentPath.getAbsolutePath());
    }

    public void cd(String destino) throws FileNotFoundException {
        if (destino.equals("..") && currentPath.getParentFile().isDirectory()) {
            currentPath = currentPath.getParentFile();
        } else {
            File target = new File(currentPath, destino);
            if (target.isDirectory()) {
                currentPath = target;
            } else if (new File(destino).isDirectory()) {
                currentPath = new File(destino);
            } else {
                throw new FileNotFoundException("No se puede acceder burro");
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

    public void mkdir(String nombre) throws FileAlreadyExistsException {
        File nuevoDir = new File(currentPath + separator + nombre);
        if (nuevoDir.exists()) {
            throw new FileAlreadyExistsException("ERROR: El directorio ya existe");
        } else if (nuevoDir.mkdir()) {
            System.out.println("Directorio creado: " + nuevoDir.getAbsolutePath());
        } else {
            System.out.println("ERROR: No se pudo crear el directorio");
        }
    }

    void rm(String nombre) throws FileNotFoundException {
        File x = new File(currentPath, nombre);
        if (!x.exists()){
            throw new FileNotFoundException("ERROR: no existe " + nombre);
        }
        if (x.delete()) {
            System.out.println("Eliminado");
        } else {
            System.out.println("ERROR: no se pudo eliminar");
        }
    }

    void ls(){
        File [] lista = currentPath.listFiles();
        if (lista != null) {
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

    void ll(){
        File [] lista = currentPath.listFiles();
        if (lista != null) {
            for (File l : lista){
                if (l.isDirectory()){
                    System.out.println("[D] " + l.getName() + " ultima modificacion: " + l.lastModified() +
                            " tamaño: " + l.length() + " bytes" );
                } else {
                    System.out.println("[A] " + l.getName() + " ultima modificacion: " + l.lastModified() +
                            " tamaño: " + l.length() + " bytes" );
                }
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
