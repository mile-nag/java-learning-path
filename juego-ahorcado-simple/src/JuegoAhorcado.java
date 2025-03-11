import java.util.Arrays;
import java.util.Scanner;

public class JuegoAhorcado {

    private final int intentos;
    private final String[] palabras;

    public JuegoAhorcado(int intentos, String[] palabras) {
        this.intentos = intentos;
        this.palabras = palabras;
    }

    public void jugar() {
        String palabraSecreta = obtenerPalabraAlAzar(palabras);
        char[] palabraAdivinada = ocultarPalabra(palabraSecreta);

        Scanner teclado = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego del ahorcado!");

        adivinarLaPalabra(intentos, palabraSecreta, palabraAdivinada, teclado);

        if (intentos == 0) {
            System.out.println("Te quedaste sin intentos. La palabra era: " + palabraSecreta);
        }

    }

    private void adivinarLaPalabra(int intentos, String palabraSecreta, char[] palabraAdivinada, Scanner teclado) {
        while (intentos > 0) {
            mostrarLetrasAdivinadas(intentos, palabraAdivinada);
            System.out.print("Ingresa una letra: ");
            String input = teclado.next();

            if (input.length() != 1) {
                System.out.println("Por favor, ingresa solo una letra.");
                continue;
            }

            char letra = input.toLowerCase().charAt(0);  // Convierte la letra a minúscula

            boolean acierto = esUnAciertoYMostrarLetra(palabraSecreta, palabraAdivinada, letra);

            if (!acierto) {
                intentos--;
                System.out.println("Letra incorrecta ¡Cuidado!");
            }

            if (adivinoTodasLasLetras(palabraAdivinada)) {
                System.out.println("¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
                break;
            }
        }
    }

    private boolean adivinoTodasLasLetras(char[] palabraAdivinada) {
        for (char c : palabraAdivinada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private boolean esUnAciertoYMostrarLetra(String palabraSecreta, char[] palabraAdivinada, char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    private void mostrarLetrasAdivinadas(int intentos, char[] palabraAdivinar) {
        System.out.println("\nPalabra para adivinar: " + new String(palabraAdivinar));
        System.out.println("Intentos restantes: " + intentos);
    }

    protected char[] ocultarPalabra(String palabraSecreta) {
        char[] palabraAdivinar = new char[palabraSecreta.length()];
        Arrays.fill(palabraAdivinar, '_');
        return palabraAdivinar;
    }

    private String obtenerPalabraAlAzar(String[] palabras) {
        int indiceAleatorio = (int) (Math.random() * palabras.length);
        return palabras[indiceAleatorio];
    }
}