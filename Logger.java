import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    public static void registrar(String mensagem) {
        try (FileWriter writer = new FileWriter("data/log.txt", true)) {
            writer.write(LocalDateTime.now() + " - " + mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar log.");
        }
    }
}