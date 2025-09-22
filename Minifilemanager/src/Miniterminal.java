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
            System.out.println("@usrjonas$");
            comando = scanner.nextLine();
            switch (comando){
                case "ls":
                    minifilemanager.ls(x);
                    break;
                case "cd":
                    minifilemanager.cd(x);
                    break;
                case "pwd":

                    minifilemanager.pwd(x);

                case "ll":
                    minifilemanager.ll(x);
                case "mkdir":
                    minifilemanager.mkdir(x);
                    break;
                case "rm":
                    minifilemanager.rm(x);
                    break;
                case "mv":
                    minifilemanager.mv(x,ruta);
                case "help":

            }
        }
        while (!comando.equals("exit"));
        System.out.println("Saliste del terminal");
    }
}
