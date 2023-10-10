import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VentanaRegistroEstudiante {
    Connection con;
    DefaultListModel mod = new DefaultListModel();
    Statement statement;
    ResultSet resultSet;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton registrarEstudianteButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;

    public void conectar(){
        con = Connection.conectar();
    }

    public void listarEstudiantes() {
        conectar();
        comboBox1.setModel((ComboBoxModel) mod);
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM carrera");
            while (resultSet.next()) {
                mod.addElement(resultSet.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar estudiantes");
        }
    }



    public void insertarEstudiante() {
        conectar();
        String nombre = textField1.getText();
        String apellido = textField2.getText();
        String rut = textField3.getText();
        String carrera = comboBox1.getSelectedItem().toString();
        String sql = "INSERT INTO estudiante (nombre, apellido, rut, carrera) VALUES ('" + nombre + "','" + apellido + "','" + rut + "','" + carrera + "')";
        try {
            con.createStatement().execute(sql);
            JOptionPane.showMessageDialog(null, "Estudiante ingresado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar estudiante");
        }
    }


    public VentanaRegistroEstudiante() {
            registrarEstudianteButton.addActionListener(new ActionListener() {
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