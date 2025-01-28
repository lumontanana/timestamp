import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KeyLogger {
    public static void main(String[] args) {
        // Generar un nombre único para el archivo de salida
        String fileName = "log_" + System.currentTimeMillis() + ".txt";

        // Formato de timestamp con mayor precisión
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)); // Abrimos el archivo en modo de escritura
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Introduce texto (escribe 'salir' para terminar):");

            while (true) {
                // Leer input del usuario
                System.out.print("> ");
                String input = scanner.nextLine();

                // Salir del bucle si el usuario escribe "salir"
                if ("s".equalsIgnoreCase(input)) {
                    System.out.println("Finalizando programa...");
                    break;
                }

                // Obtener el timestamp actual con mayor precisión
                String timestamp = LocalDateTime.now().format(formatter);

                // Escribir en el archivo
                writer.write(timestamp + " - " + input);
                writer.newLine();

                System.out.println("Entrada registrada: " + timestamp + " - " + input);
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
