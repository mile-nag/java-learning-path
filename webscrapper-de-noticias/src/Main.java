import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://www.infoquilmes.com.ar/secciones/4320/cultura";

        String html = WebScrapper.cargarWeb(url);

        Set<String> noticias = WebScrapper.obtenerTitulares(html);

        noticias.forEach(System.out::println);
    }
}