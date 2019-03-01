package views;

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

    private JMenu file, help;

    public JMenuBarMain() {
        this.file = new JMenu("Archivo");
        JMenuItem jmiRun = new JMenuItem("Correr");
        JMenuItem jmiClear = new JMenuItem("Limpiar");
        JMenuItem jmiExit = new JMenuItem("Salir");
        this.file.add(jmiRun);
        this.file.add(jmiClear);
        this.file.add(jmiExit);

        this.help = new JMenu("Ayuda");
        JMenuItem jmiAboutOf = new JMenuItem("Acerca de");
        JMenuItem jmiAyudaItem = new JMenuItem("Ayuda");
        this.help.add(jmiAboutOf);
        this.help.add(jmiAyudaItem);

        JPanel pnCentral = new JPanel();
        pnCentral.setLayout(new GridLayout(2, 0));
        pnCentral.add(new PanelEditor());
        pnCentral.add(new PanelConsola());

        add(file);
        add(help);
    }
}
