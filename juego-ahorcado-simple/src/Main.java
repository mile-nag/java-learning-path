public class Main {
    public static void main(String[] args) {
        String[] palabras = {"programacion", "computadora", "java", "desarrollo", "tecnologia","algoritmo", "framework", "depuracion", "compilador", "interfaz",
                "herencia", "polimorfismo", "encapsulamiento", "abstraccion", "debugging", "polimorfismo"};
        JuegoAhorcado juegoAhorcado = new JuegoAhorcado(6, palabras);
        juegoAhorcado.jugar();
    }
}