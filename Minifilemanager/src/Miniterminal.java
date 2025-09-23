import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Miniterminal {
    public static void main(String[] args){
        Minifilemanager minifilemanager = new Minifilemanager();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.print("@usrjonas:~$ ");
            comando = scanner.nextLine();
            String []c = comando.split(" ");

            switch (c[0]) {
                case "ls":
                    minifilemanager.ls();
                    break;

                case "cd":
                    if (c.length > 1) {
                        try {
                            minifilemanager.cd(c[1]);
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Uso: cd <directorio>");
                    }
                    break;

                case "pwd":
                    minifilemanager.pwd();
                    break;

                case "ll":
                    minifilemanager.ll();
                    break;

                case "mkdir":
                    if (c.length > 1) {
                        try {
                            minifilemanager.mkdir(c[1]);
                        } catch (FileAlreadyExistsException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Uso: mkdir <nombre>");
                    }
                    break;

                case "rm":
                    if (c.length > 1) {
                        try {
                            minifilemanager.rm(c[1]);
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Uso: rm <archivo>");
                    }
                    break;

                case "mv":
                    if (c.length > 2) {
                        minifilemanager.mv(c[1], c[2]);
                    } else {
                        System.out.println("Uso: mv <origen> <destino>");
                    }
                    break;

                case "help":
                    minifilemanager.help();
                    break;
            }
        }
        while (!comando.equals("exit"));
        System.out.println("Saliste del terminal");
    }
}
