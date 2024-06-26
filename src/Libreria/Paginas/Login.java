package Libreria.Paginas;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import Libreria.Paginas.Admin.AdminMainPage;
import Libreria.Paginas.Usuario.UserMainPage;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

    public Login(){
        JFrame frame = new JFrame("Bibliopolis");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(600,600));

        //Panel del encabezado
        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(600,100));
        panelNorte.setBackground(Color.black);

        //Panel del cuerpo
        JPanel panelCentro = new JPanel();
        panelCentro.setPreferredSize(new Dimension(900,500));

        //Panel del contenido dentro del cuerpo
        JPanel contenido = new JPanel();
        contenido.setLayout(null);
        contenido.setPreferredSize(new Dimension(300,400));

        //Etiquetas del usuario y la contraseña

        JLabel usuario = new JLabel("Correo electronico:");
        usuario.setBounds(50,50,175,50);
        JLabel contraseña = new JLabel("Contraseña:");
        contraseña.setBounds(50,150,100,50);

        //Área de texto del usuario y la contraseña
        JTextField userText = new JTextField(10);
        TextPrompt placeholder1 = new TextPrompt("example@gmail.com",userText);
        placeholder1.changeAlpha(0.75f);
        placeholder1.changeStyle(Font.ITALIC);
        userText.setBounds(50,100,175,30);

        JPasswordField passwordText = new JPasswordField(10);
        TextPrompt placeholder2 = new TextPrompt("",passwordText);
        placeholder2.changeAlpha(0.75f);
        passwordText.setBounds(50,200,175,30);

        //Botón de inicio de sesión

        JLabel login = new JLabel("Iniciar Sesión");
        login.setBounds(100,260,90,30);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Listener para verificar si el usuario y contraseña son los correctos comparando con la base de datos.
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = userText.getText();
                String password = passwordText.getText();
                ConexionBD conexionBD = new ConexionBD();
                LoginManager loginManager = new LoginManager(conexionBD);

                boolean estaLogueado = loginManager.login(email, password);
                boolean esAdmin = loginManager.isAdmin(email);
                if (estaLogueado && esAdmin){
                    frame.dispose();
                    AdminMainPage adminMainPage = new AdminMainPage();
                }else if (estaLogueado){
                    // entrar a pagina principal como usuario normal
                    frame.dispose();
                    UserMainPage userMainPage = new UserMainPage();

                }else {
                    // Mostrar error
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Por favor, inténtalo de nuevo.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        };


        // Escuchar el evento del boton
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Llamar al ActionListener cuando se haga clic en el botón
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });

        // Boton registrase
        JLabel regist = new JLabel("Regístrate");
        regist.setBounds(110,240,90,30);
        regist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        regist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Cerrar la ventana actual
                frame.dispose();

                // Abrir una nueva ventana
                RegisterPage registerPage = new RegisterPage(); // Reemplaza "OtraVentana" con el nombre de tu clase de ventana
            }
        });


        //Icono del logo en el encabezado
        ImageIcon logo = new ImageIcon("src/Libreria/imagenes/logo_blanco.png");
        JLabel etiquetaFoto1 = new JLabel(logo);

        //Adicion dentro del panel "contenido"
        contenido.add(usuario);
        contenido.add(contraseña);
        contenido.add(userText);
        contenido.add(passwordText);
        contenido.add(regist);
        contenido.add(login);

        //Lineas de alrededor de "Inicio de sesión"
        contenido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Inicio de Sesión",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));



        panelCentro.add(contenido, BorderLayout.CENTER);
        panelNorte.add(etiquetaFoto1);

        frame.add(panelNorte, BorderLayout.NORTH);
        frame.add(panelCentro, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Login ver = new Login();
    }
}
