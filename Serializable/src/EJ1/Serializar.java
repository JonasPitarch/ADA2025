package EJ1;

import java.io.*;
import java.util.Scanner;

public class Serializar {

    static class Notas implements Serializable {
        private String asignatura;
        private int nota;

        public Notas(String asignatura, int nota) {
            this.asignatura = asignatura;
            this.nota = nota;
        }

        public String getAsignatura() {
            return asignatura;
        }

        public void setAsignatura(String asignatura) {
            this.asignatura = asignatura;
        }

        public int getNota() {
            return nota;
        }

        public void setNota(int nota) {
            if (nota < 0) {
                System.out.println("Una nota no puede ser negativa, moniato.");
            } else {
                this.nota = nota;
            }
        }

        @Override
        public String toString() {
            return "Notas{" +
                    "asignatura='" + asignatura + '\'' +
                    ", nota=" + nota +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántas asignaturas quieres introducir? ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        Notas[] notas = new Notas[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nAsignatura " + (i + 1) + ":");
            System.out.print("Nombre de la asignatura: ");
            String asignatura = sc.nextLine();

            int nota;
            while (true) {
                System.out.print("Nota (0-10): ");
                nota = sc.nextInt();
                sc.nextLine();
                if (nota >= 0 && nota <= 10) break;
                System.out.println("⚠️ La nota debe estar entre 0 y 10.");
            }

            notas[i] = new Notas(asignatura, nota);
        }

        System.out.println("Serializando...");
        Thread.sleep(200);

        // Serialización
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notas.dat"))) {
            for (Notas n : notas) {
                oos.writeObject(n);
            }
            System.out.println("\n✅ Serialización completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialización
        System.out.println("\nAhora vamos a deserializarlo...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("notas.dat"))) {
            while (true) {
                Notas e = (Notas) in.readObject();
                System.out.println(e);
            }
        } catch (EOFException eof) {
            System.out.println("📘 Fin del archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
