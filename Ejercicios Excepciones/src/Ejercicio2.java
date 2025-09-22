import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true){
                System.out.println("Dame un nominador");
                int nominador = sc.nextInt();
                System.out.println("Dame un denominador");
                int denominador = sc.nextInt();
                int res = nominador/denominador;
                System.out.println("El resultado de la división es: " + res);
            }}
        catch (InputMismatchException e){
            System.out.println("Error: Introduciste una letra cuando tenías que introducir un numero entero " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: La division no se puede realizar " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
