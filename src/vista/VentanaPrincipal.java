
package vista;

import heroes.*;
import mensajeria.ServicioTelegram;
import misiones.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Ventana principal del sistema.
 * Permite registrar héroes, crear misiones y asignarlas.
 * 
 * @author juan esteban hernandez
 */
public class VentanaPrincipal extends JFrame {

    private JTextField txtHeroe;
    private JTextField txtMision;

    private JComboBox<String> comboHeroe;
    private JComboBox<String> comboHabilidad;

    private DefaultListModel<String> modeloHeroes = new DefaultListModel<>();
    private DefaultListModel<String> modeloMisiones = new DefaultListModel<>();

    private JList<String> listaHeroes;
    private JList<String> listaMisiones;
    
    private SistemaMisiones sistema = new SistemaMisiones();

    /**
     * Constructor que crea y configura la interfaz gráfica.
     */
    public VentanaPrincipal(){

        setTitle("S.H.I.E.L.D Mission Control");
        setSize(700,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Color fondoPrincipal = new Color(45,45,45);
        Color panelColor = new Color(70,70,70);
        Color botonColor = new Color(100,100,100);
        Color campoColor = new Color(90,90,90);

        getContentPane().setBackground(fondoPrincipal);

        JLabel titulo = new JLabel("️ S.H.I.E.L.D MISSION CONTROL ️");
        titulo.setBounds(200,10,350,30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo);

        // PANEL HEROES
        JPanel panelHeroes = new JPanel();
        panelHeroes.setLayout(null);
        panelHeroes.setBackground(panelColor);
        panelHeroes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Registrar Heroe",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial",Font.BOLD,12),
                Color.WHITE
        ));
        panelHeroes.setBounds(20,50,300,150);
        add(panelHeroes);

        JLabel l1 = new JLabel("Nombre:");
        l1.setForeground(Color.WHITE);
        l1.setBounds(10,30,80,25);
        panelHeroes.add(l1);

        txtHeroe = new JTextField();
        txtHeroe.setBounds(80,30,120,25);
        txtHeroe.setBackground(campoColor);
        txtHeroe.setForeground(Color.WHITE);
        panelHeroes.add(txtHeroe);

        comboHeroe = new JComboBox<>(new String[]{"IronMan","Thor","Hulk","Aquaman"});
        comboHeroe.setBounds(80,60,120,25);
        panelHeroes.add(comboHeroe);

        JButton btnHeroe = new JButton("Registrar");
        btnHeroe.setBounds(80,100,120,30);
        btnHeroe.setBackground(botonColor);
        btnHeroe.setForeground(Color.WHITE);
        panelHeroes.add(btnHeroe);

        // PANEL MISIONES
        JPanel panelMisiones = new JPanel();
        panelMisiones.setLayout(null);
        panelMisiones.setBackground(panelColor);
        panelMisiones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Crear Mision",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial",Font.BOLD,12),
                Color.WHITE
        ));
        panelMisiones.setBounds(350,50,300,150);
        add(panelMisiones);

        JLabel l2 = new JLabel("Nombre:");
        l2.setForeground(Color.WHITE);
        l2.setBounds(10,30,80,25);
        panelMisiones.add(l2);

        txtMision = new JTextField();
        txtMision.setBounds(80,30,120,25);
        txtMision.setBackground(campoColor);
        txtMision.setForeground(Color.WHITE);
        panelMisiones.add(txtMision);

        comboHabilidad = new JComboBox<>(new String[]{"Volar","Fuerza","Electricidad","Agua"});
        comboHabilidad.setBounds(80,60,120,25);
        panelMisiones.add(comboHabilidad);

        JButton btnMision = new JButton("Crear");
        btnMision.setBounds(80,100,120,30);
        btnMision.setBackground(botonColor);
        btnMision.setForeground(Color.WHITE);
        panelMisiones.add(btnMision);

        // LISTAS
        listaHeroes = new JList<>(modeloHeroes);
        JScrollPane scrollHeroes = new JScrollPane(listaHeroes);
        scrollHeroes.setBounds(80,220,200,150);
        add(scrollHeroes);

        listaMisiones = new JList<>(modeloMisiones);
        JScrollPane scrollMisiones = new JScrollPane(listaMisiones);
        scrollMisiones.setBounds(400,220,200,150);
        add(scrollMisiones);

        JButton btnAsignar = new JButton("Asignar Misiones");
        btnAsignar.setBounds(280,380,150,30);
        btnAsignar.setForeground(Color.WHITE);
        btnAsignar.setBackground(botonColor);
        add(btnAsignar);

        btnHeroe.addActionListener(e -> registrarHeroe());
        btnMision.addActionListener(e -> crearMision());
        btnAsignar.addActionListener(e -> asignarMisiones());
    }

    /**
     * Registra un nuevo héroe en el sistema.
     */
    private void registrarHeroe(){

        String nombre = txtHeroe.getText();
        String tipo = comboHeroe.getSelectedItem().toString();

        Heroe h = HeroeFactory.crearHeroe(tipo, nombre);
        sistema.agregarHeroe(h);
        modeloHeroes.addElement(nombre);
    }

    /**
     * Crea una nueva misión.
     */
    private void crearMision(){

        String nombre = txtMision.getText();

        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingrese el nombre de la mision");
            return;
        }

        String habilidadSeleccionada =
                comboHabilidad.getSelectedItem().toString();

        TipoHabilidad habilidad =
                TipoHabilidad.valueOf(
                        habilidadSeleccionada.toUpperCase()
                );

        Mision m = new Mision(nombre, habilidad);

        sistema.agregarMision(m);
        modeloMisiones.addElement(nombre);
        txtMision.setText("");
    }

    /**
     * Asigna las misiones a los héroes disponibles.
     */
    private void asignarMisiones(){

        ServicioTelegram telegram = new ServicioTelegram();
        AsignarMision asignador = new AsignarMision(telegram);

        try{

            for(Mision m : sistema.getMisiones()){
                asignador.asignar(m, sistema.getHeroes());
            }

            JOptionPane.showMessageDialog(this,"Misiones asignadas correctamente");

        }catch(Exception e){

            JOptionPane.showMessageDialog(this,e.getMessage());

        }

    }

}