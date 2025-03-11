import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ClienteForm extends JFrame {
    private JButton btnGuardar;
    private JList<String> listaClientes;
    private DefaultListModel<String> listaElementos;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JPanel contenedorPrincipal;
    private JButton btnEliminar;
    private JButton btnAgregar;
    private List<Cliente> clientes;

    private Cliente cliente;

    public ClienteForm() {
        // Inicialización de componentes
        listaElementos = new DefaultListModel<>();
        listaClientes.setModel(listaElementos);
        clientes = new ArrayList<>();

        btnGuardar.addActionListener(e -> {
            crearCliente(false);
            //OptionPane.showMessageDialog(btnGuardar, "Cliente guardado");
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarCliente();
            }
        });

        listaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                seleccionarCliente();
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCliente(true);
            }
        });
    }

    private void seleccionarCliente() {
        int index = listaClientes.getSelectedIndex();
        cliente = clientes.get(index);
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtEmail.setText(cliente.getEmail());
        txtTelefono.setText(cliente.getTelefono());
        txtDireccion.setText(cliente.getDireccion());
    }

    private void eliminarCliente() {
        int index = listaClientes.getSelectedIndex();
        clientes.remove(index);
        renderizarListaClientes();
    }

    private void crearCliente(boolean esNuevo) {
        if (esNuevo) {
            cliente = new Cliente();
        }

        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setDireccion(txtDireccion.getText());

        if (esNuevo) {
            clientes.add(cliente);
        }

        renderizarListaClientes();

        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

    private void renderizarListaClientes() {
        listaElementos.clear();  // Limpiar la lista antes de renderizar
        for (Cliente cliente : clientes) {
            listaElementos.addElement(cliente.getFullName());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClienteForm");
        frame.setContentPane(new ClienteForm().contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getContenedorPrincipal() {
        return contenedorPrincipal;
    }
}