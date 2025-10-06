package EJ1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializar {
    static class Notas implements Serializable {
        String asignatura;
        int nota;

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
            if (nota<0){
                System.out.println("Una nota no pot ser negativa moniato");
            }
            else {
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

    public static void main(String[] args) {

        List<Notas> notas = new ArrayList<>();
        notas.add(new Notas("Programacion", 5));
        notas.add(new Notas("Empresariales", 7));
        notas.add(new Notas("Inglés", 7));
        notas.add(new Notas("Sistemas", 8));
        notas.add(new Notas("Base de Datos", 5));
        notas.add(new Notas("Lenguaje de marcas", 8));
        notas.add(new Notas("Entornos de Desarrollo", 6));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notas.dat"))) {
            for (Notas n : notas) {
                oos.writeObject(n);
            }
            System.out.println("Serialización completada!!!!!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ahora vamos a deserializarlo...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("notas.dat"))) {
            while (true) {
                Notas e = (Notas) in.readObject();
                System.out.println(e);
            }
        } catch (EOFException eof) {
            System.out.println("Fin del archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
