import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int x[]= new int[3];
        try {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 4; i++) {
                x[i]= sc.nextInt();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: El array solo mide 3 revisa el for " + e.getMessage());
        }
        catch (ArithmeticException e){
            System.out.println("Error: Estas introduciendo un valor alfabético en lugar de uno numérco " + e.getMessage());
        }

    }
}
