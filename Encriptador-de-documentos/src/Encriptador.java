public class Encriptador {
    private int clave = 1;

    public void setClave(int clave) {
        if (clave == 0) {
            throw new IllegalArgumentException("La clave no puede ser 0.");
        }
        this.clave = clave;
    }

    public String encriptar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            int codigoAscii = texto.charAt(i);
            codigoAscii = codigoAscii * clave;
            resultado.append(codigoAscii).append("_");
        }
        return resultado.toString();
    }

    public String desencriptar(String texto) {
        StringBuilder resultado = new StringBuilder();
        String[] numeros = texto.split("_");
        for (String strNumero : numeros) {
            int numero = Integer.parseInt(strNumero);
            numero = numero / clave;
            resultado.append((char) numero);
        }
        return resultado.toString();
    }
}