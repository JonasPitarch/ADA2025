import java.io.*;
public class Ejercicio1 {
    public static void main(String[] args) {
        byte [] buf = new byte[8192];
        long total=0;
        try (
            BufferedInputStream br = new BufferedInputStream(new FileInputStream("Documentos/pi-million.txt"));
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("pi-million.copy"))
        ){
            int n;
            while ((n = br.read(buf))!=-1){
                bw.write(buf,0,n);
                total += n;
            }
            System.out.println("Bytes copiats: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}