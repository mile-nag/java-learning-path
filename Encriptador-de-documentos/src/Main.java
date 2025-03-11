import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Elija la opción que desea:");
        System.out.println("1. Encriptar");
        System.out.println("2. Desencriptar");

        String opcionElegida = teclado.nextLine();

        System.out.println("Ingrese la dirección del archivo: ");
        String rutaArchivo = teclado.nextLine();

        Encriptador encriptador = new Encriptador();
        encriptador.setClave(2); // Clave fija (podría ser ingresada por el usuario)

        try {
            String texto = FileUtil.cargarArchivo(rutaArchivo);
            String resultado;

            if ("1".equals(opcionElegida)) {
                resultado = encriptador.encriptar(texto);
                System.out.println("Texto encriptado: " + resultado);
            } else if ("2".equals(opcionElegida)) {
                resultado = encriptador.desencriptar(texto);
                System.out.println("Texto desencriptado: " + resultado);
            } else {
                System.out.println("Opción no válida.");
                return;
            }

            FileUtil.guardarArchivo(rutaArchivo, resultado);
            System.out.println("Proceso completado con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            teclado.close();
        }
    }
}