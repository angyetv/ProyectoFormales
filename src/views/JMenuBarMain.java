package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author angyedanielatorresveloza
 */
public class JMenuBarMain extends JMenuBar {

    private JMenu archivo, ayuda;

    public JMenuBarMain() {
        this.archivo = new JMenu("Archivo");
        JMenuItem correr = new JMenuItem("Correr");
        correr.setBackground(Color.decode("#444444"));
        JMenuItem limpiar = new JMenuItem("Limpiar");
        JMenuItem salir = new JMenuItem("Salir");
        this.archivo.add(correr);
        this.archivo.add(limpiar);
        this.archivo.add(salir);
        
        this.ayuda = new JMenu("Ayuda");
        JMenuItem acercaDe = new JMenuItem("Acerca de");
        JMenuItem ayudaItem = new JMenuItem("Ayuda");
        this.ayuda.add(acercaDe);
        this.ayuda.add(ayudaItem);
        
        JPanel pnCentral = new JPanel();
        pnCentral.setLayout(new GridLayout(2, 0));
        pnCentral.add(new PanelEditor());
        pnCentral.add(new PanelConsola());
        
        add(archivo);
        add(ayuda);
    }
}
