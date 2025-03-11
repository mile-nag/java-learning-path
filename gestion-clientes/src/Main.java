import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteForm form = new ClienteForm ();
        form.setContentPane(form.getContenedorPrincipal());
        form.setSize(500, 350);
        form.setVisible(true);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}