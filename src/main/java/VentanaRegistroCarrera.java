import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VentanaRegistroCarrera {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton registrarCarreraButton;
    private JButton cancelarButton;
    Connection con;
    DefaultListModel mod = new DefaultListModel();
    Statement statement;
    ResultSet resultSet;

    public void conectar(){
        con = Connection.conectar();
    }

    public void listarCarreras() {
        conectar();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM carrera");
            while (resultSet.next()) {
                mod.addElement(resultSet.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar carreras");
        }
    }

    public void insertarCarrera() {
        conectar();
        String nombre = textField1.getText();
        String codigo = textField2.getText();
        String facultad = textField3.getText();
        String sql = "INSERT INTO carrera (nombre, codigo, facultad) VALUES ('" + nombre + "','" + codigo + "','" + facultad + "')";
        try {
            con.createStatement().execute(sql);
            JOptionPane.showMessageDialog(null, "Carrera ingresada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar carrera");
        }
    }
    public VentanaRegistroCarrera() {
        registrarCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}