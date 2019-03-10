package views;

import controllers.Actions;
import controllers.Controller;
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

    private JMenu file, help;

    public JMenuBarMain() {
        setBackground(Color.decode("#001a57"));
        this.file = new JMenu("Archivo");
        JMenuItem jmiRun = new JMenuItem("Ejecutar");
        jmiRun.addActionListener(Controller.getInstance());
        jmiRun.setActionCommand(Actions.RUN.name());
        
        JMenuItem jmiClear = new JMenuItem("Limpiar Todo");
        jmiClear.addActionListener(Controller.getInstance());
        jmiClear.setActionCommand(Actions.CLEAR.name());
        
        JMenuItem jmiExit = new JMenuItem("Salir");
        jmiExit.addActionListener(Controller.getInstance());
        jmiExit.setActionCommand(Actions.EXIT.name());
        
        this.file.add(jmiRun);
        this.file.add(jmiClear);
        this.file.add(jmiExit);

        this.help = new JMenu("Ayuda");
        JMenuItem jmiAboutOf = new JMenuItem("Acerca de");
        jmiAboutOf.addActionListener(Controller.getInstance());
        jmiAboutOf.setActionCommand(Actions.ABOUT_OF.name());
        
        JMenuItem jmiAyudaItem = new JMenuItem("Ayuda");
        jmiAyudaItem.addActionListener(Controller.getInstance());
        jmiAyudaItem.setActionCommand(Actions.HELP.name());
        
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