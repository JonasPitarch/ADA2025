import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Dime el numero que quieres introducir? ");
                int numero = sc.nextInt();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Error: Introduciste una letra cuando tenías que introducir un numero entero" + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}