import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WebScrapper {

    public static String cargarWeb(String urlStr) throws IOException {
        StringBuilder html = new StringBuilder();
        URL url = new URL(urlStr);

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                html.append(linea);
            }
        }
        return html.toString();
    }

    public static Set<String> obtenerTitulares(String html) {
        Set<String> titulares = new HashSet<>();
        int index = 0;

        while (index != -1) {
            int[] resultado = encontrarSiguienteIndice(html, index);
            int nextIndex = resultado[0];
            int offset = resultado[1];

            if (nextIndex == -1) break;

            int valueStart = nextIndex + offset;
            int valueEnd = html.indexOf("'", valueStart);
            if (valueEnd == -1) break;

            String titular = decodeHtmlEntities(html.substring(valueStart, valueEnd).trim());

            if (!titular.equalsIgnoreCase("temperatura")) {
                titulares.add(titular);
            }

            index = valueEnd + 1;
        }
        return titulares;
    }

    private static int[] encontrarSiguienteIndice(String html, int index) {
        int altIndex = html.indexOf("alt='", index);
        int titleIndex = html.indexOf("title='", index);

        if (altIndex == -1 && titleIndex == -1) return new int[]{-1, 0};

        return (altIndex != -1 && (titleIndex == -1 || altIndex < titleIndex))
                ? new int[]{altIndex, 5}  // "alt='"
                : new int[]{titleIndex, 7}; // "title='"
    }

    private static String decodeHtmlEntities(String text) {
        return text.replace("&quot;", "\"")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}

