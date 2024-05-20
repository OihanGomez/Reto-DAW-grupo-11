package Libreria.Paginas;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.RegisterManager;
import Libreria.Paginas.Usuario.UserMainPage;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage {
        public RegisterPage() {
                JFrame frame = new JFrame("Bibliopolis");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.setPreferredSize(new Dimension(600, 700));

                JPanel panelNorte = new JPanel();
                panelNorte.setLayout(new BorderLayout());
                panelNorte.setPreferredSize(new Dimension(600, 100));
                panelNorte.setBackground(Color.black);

                JPanel panelCentro = new JPanel();
                panelCentro.setPreferredSize(new Dimension(900, 500));

                JPanel contenido = new JPanel();
                contenido.setLayout(null);
                contenido.setPreferredSize(new Dimension(300, 500));

                JLabel usuario = new JLabel("Nombre de usuario:");
                usuario.setBounds(50, 30, 150, 30);

                JLabel contraseña = new JLabel("Contraseña:");
                contraseña.setBounds(50, 90, 100, 30);

                JLabel contraseñaConfirmacion = new JLabel("Confirmar contraseña:");
                contraseñaConfirmacion.setBounds(50, 150, 150, 30);

                JLabel correo = new JLabel("Correo electrónico:");
                correo.setBounds(50, 210, 130, 30);

                JLabel nombre = new JLabel("Nombre:");
                nombre.setBounds(50, 270, 100, 30);

                JLabel apellidos = new JLabel("Apellidos:");
                apellidos.setBounds(50, 330, 100, 30);

                JLabel direccion = new JLabel("Dirección:");
                direccion.setBounds(50, 390, 100, 30);

                JButton regist = new JButton("Registrarse");
                regist.setBounds(100, 450, 120, 30);
                regist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                JPasswordField passwordText = new JPasswordField(10);
                TextPrompt placeholder2 = new TextPrompt("Ingresa tu contraseña", passwordText);
                placeholder2.changeAlpha(0.75f);
                placeholder2.changeStyle(Font.ITALIC);
                passwordText.setBounds(50, 115, 175, 30);

                JPasswordField passwordConfirm = new JPasswordField(30);
                TextPrompt placeholder3 = new TextPrompt("Confirma tu contraseña", passwordConfirm);
                placeholder3.changeAlpha(0.75f);
                placeholder3.changeStyle(Font.ITALIC);
                passwordConfirm.setBounds(50, 175, 175, 30);

                JTextField añadirCorreo = new JTextField(30);
                TextPrompt placeholder4 = new TextPrompt("Ingresa tu correo electrónico", añadirCorreo);
                placeholder4.changeAlpha(0.75f);
                placeholder4.changeStyle(Font.ITALIC);
                añadirCorreo.setBounds(50, 235, 175, 30);

                JTextField nombreText = new JTextField(30);
                TextPrompt placeholder5 = new TextPrompt("Ingresa tu nombre", nombreText);
                placeholder5.changeAlpha(0.75f);
                placeholder5.changeStyle(Font.ITALIC);
                nombreText.setBounds(50, 295, 175, 30);

                JTextField apellidosText = new JTextField(30);
                TextPrompt placeholder6 = new TextPrompt("Ingresa tus apellidos", apellidosText);
                placeholder6.changeAlpha(0.75f);
                placeholder6.changeStyle(Font.ITALIC);
                apellidosText.setBounds(50, 355, 175, 30);

                JTextField direccionText = new JTextField(30);
                TextPrompt placeholder7 = new TextPrompt("Ingresa tu dirección", direccionText);
                placeholder7.changeAlpha(0.75f);
                placeholder7.changeStyle(Font.ITALIC);
                direccionText.setBounds(50, 415, 175, 30);

                ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
                JLabel etiquetaFoto1 = new JLabel(logo);

                contenido.add(usuario);
                contenido.add(contraseña);
                contenido.add(passwordText);
                contenido.add(regist);
                contenido.add(passwordConfirm);
                contenido.add(contraseñaConfirmacion);
                contenido.add(correo);
                contenido.add(añadirCorreo);
                contenido.add(nombre);
                contenido.add(nombreText);
                contenido.add(apellidos);
                contenido.add(apellidosText);
                contenido.add(direccion);
                contenido.add(direccionText);
                contenido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Registro",
                        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

                panelCentro.add(contenido, BorderLayout.CENTER);
                panelNorte.add(etiquetaFoto1);

                frame.add(panelNorte, BorderLayout.NORTH);
                frame.add(panelCentro, BorderLayout.CENTER);

                frame.pack();
                frame.setVisible(true);

                ConexionBD conexionBD = new ConexionBD(); // Crea una instancia de ConexionBD
                RegisterManager registerManager = new RegisterManager(conexionBD); // Crea una instancia de RegisterManager

                regist.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String password = new String(passwordText.getPassword());
                                String confirmPassword = new String(passwordConfirm.getPassword());
                                String email = añadirCorreo.getText();
                                String name = nombreText.getText();
                                String lastName = apellidosText.getText();
                                String address = direccionText.getText();


                                if (password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || name.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                                } else if (!password.equals(confirmPassword)) {
                                        JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                                } else if (registerManager.register(email, password, name, lastName, address)) {
                                        UserMainPage userMainPage = new UserMainPage();
                                        frame.dispose();
                                }
                        }
                });
        }

        public static void main(String[] args) {
                RegisterPage rp = new RegisterPage();
        }
}
