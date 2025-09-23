import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Miniterminal {
    public static void main(String[] args) throws FileNotFoundException {
        Minifilemanager minifilemanager = new Minifilemanager();
        Scanner scanner = new Scanner(System.in);
        String comando;
        String ruta = ".";
        File x = new File(ruta);
        do {
            System.out.print("@usrjonas$:");
            comando = scanner.nextLine();
            switch (comando){
                case "ls":
                    minifilemanager.ls(x);
                    break;
                case "cd":
                    minifilemanager.cd(comando);
                    break;
                case "pwd":
                    minifilemanager.pwd(x);
                    break;

                case "ll":
                    minifilemanager.ll(x);
                    break;
                case "mkdir":
                    System.out.print("Nombre del directorio: ");
                    String dir = scanner.nextLine();
                    minifilemanager.mkdir(dir);
                    break;
                case "rm":
                    minifilemanager.rm(x);
                    break;
                case "mv":
                    System.out.print("Archivo origen: ");
                    String origen = scanner.nextLine();
                    System.out.print("Archivo destino: ");
                    String destino = scanner.nextLine();
                    minifilemanager.mv(origen, destino);
                    break;

                case "help":
                    minifilemanager.help();

            }
        }
        while (!comando.equals("exit"));
        System.out.println("Saliste del terminal");
    }
}
