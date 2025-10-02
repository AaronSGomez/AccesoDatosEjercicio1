import java.nio.file.*;
import java.nio.charset.StandardCharsets;  //importamos libreria para caracteres universales ñ y acentos
import java.io.*;

import java.util.*;


public class TextoPlano {

    private static Path RUTA = Paths.get("clientes.txt");

    public static void main(String[] args) throws IOException {

        //lista clientes
        List<Cliente> clientes = List.of(
                new Cliente(1, "Ana", "ana@correo.com", 1200),
                new Cliente(2, "Pepe", "pepe@correo.com", 1560),
                new Cliente(3, "Roberto", "roberto@correo.com", 1700)
        ); //List.of abstracto de creacion de clientes

        try (BufferedWriter bw = Files.newBufferedWriter(RUTA, StandardCharsets.UTF_8)) {
            for (Cliente c : clientes) {
                bw.write(c.writeLine());
                bw.newLine();
            }
            System.out.println("Escrito en " + RUTA.toAbsolutePath()); //RUTA ABSOLUTA DONDE SE ESCRIBIO EL ARCHIVO
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Cliente> leidos = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = br.readLine()) != null) {
               String[] partes = linea.split(";", -1); // -1 si no hay nada entre los separadores devuelve un vacio
                if(partes.length != 4){
                    System.err.println("Linea con formato incorreto" + linea);
                }
                try{
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String email = partes[2];
                    Double saldo = Double.parseDouble(partes[3]);

                    leidos.add(new Cliente(id,nombre,email,saldo));
                }catch (NumberFormatException ex){
                    System.err.println("Error de conversion numeros" + linea);
                }
            }
        } catch (IOException c) {
            c.printStackTrace();
        }
        System.out.println("Leidos");
        leidos.forEach(System.out::println);
    }
}
