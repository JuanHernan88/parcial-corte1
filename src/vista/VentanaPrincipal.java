
package vista;

import heroes.*;
import interfaces.Habilidad;
import mensajeria.ServicioTelegram;
import misiones.*;
import heroes.HeroeFactory;
import misiones.SistemaMisiones;
import misiones.TipoHabilidad;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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


    public VentanaPrincipal(){

        setTitle("S.H.I.E.L.D Mission Control");
        setSize(700,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //  COLORES ESTILO SHIELD
        Color fondoPrincipal = new Color(45,45,45);
        Color panelColor = new Color(70,70,70);
        Color botonColor = new Color(100,100,100);
        Color campoColor = new Color(90,90,90);

        getContentPane().setBackground(fondoPrincipal);

        // TITULO
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


        // LISTA HEROES
        listaHeroes = new JList<>(modeloHeroes);
        listaHeroes.setBackground(new Color(60,60,60));
        listaHeroes.setForeground(Color.WHITE);

        JScrollPane scrollHeroes = new JScrollPane(listaHeroes);
        scrollHeroes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Heroes Registrados",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial",Font.BOLD,12),
                Color.BLUE
        ));
        scrollHeroes.setBounds(80,220,200,150);
        add(scrollHeroes);


        // LISTA MISIONES
        listaMisiones = new JList<>(modeloMisiones);
        listaMisiones.setBackground(new Color(60,60,60));
        listaMisiones.setForeground(Color.WHITE);

        JScrollPane scrollMisiones = new JScrollPane(listaMisiones);
        scrollMisiones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Misiones",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial",Font.BOLD,12),
                Color.BLUE
        ));
        scrollMisiones.setBounds(400,220,200,150);
        add(scrollMisiones);


        // BOTON ASIGNAR
        JButton btnAsignar = new JButton("Asignar Misiones");
        btnAsignar.setBounds(280,380,150,30);
        btnAsignar.setBackground(new Color(120,120,120));
        btnAsignar.setForeground(Color.WHITE);
        add(btnAsignar);


        // EVENTOS
        btnHeroe.addActionListener(e -> registrarHeroe());
        btnMision.addActionListener(e -> crearMision());
        btnAsignar.addActionListener(e -> asignarMisiones());
    }


    private void registrarHeroe(){

        String nombre = txtHeroe.getText();
        String tipo = comboHeroe.getSelectedItem().toString();

        Heroe h = HeroeFactory.crearHeroe(tipo, nombre);
        sistema.agregarHeroe(h);
        modeloHeroes.addElement(nombre);
    }


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