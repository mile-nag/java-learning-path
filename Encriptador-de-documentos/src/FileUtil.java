import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String cargarArchivo(String ruta) throws IOException {
        return new String(Files.readAllBytes(Paths.get(ruta)));
    }

    public static void guardarArchivo(String ruta, String contenido) throws IOException {
        Files.write(Paths.get(ruta), contenido.getBytes());
    }
}