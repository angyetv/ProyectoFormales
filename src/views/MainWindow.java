package views;

import controllers.Actions;
import controllers.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author angyedanielatorresveloza
 */
public class MainWindow extends JFrame {

    private JMenuBarMain jMenuBarMain;
    private static PanelConsola panelConsole;
    private PanelEditor panelEditor;
    private static String output;

    public MainWindow() {
        designWindow();
        setSize(600, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.decode("#f0f0f0"));

//        ImageIcon imageIcon = new ImageIcon("src/Img/LOGO.PNG");
        Image image = new ImageIcon(getClass().getResource("/Img/LOGO.PNG")).getImage();

//        Image image = imageIcon.getImage();
        this.setIconImage(image);
        this.setTitle("ANALIZADOR LEXICO Y SINTACTICO DANYA");

        this.output = "";

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());

        JPanel pnButtons = new JPanel();
        pnButtons.setBackground(Color.decode("#f0f0f0"));

        pnButtons.setLayout(new GridLayout(1, 3));
        JButton btnCargarFile = new JButton("Abrir programa", new ImageIcon(getClass().getResource("/Img/carpeta.png")));
//        JButton btnCargarFile = new JButton("Abrir programa", new ImageIcon("src/Img/carpeta.png"));
        btnCargarFile.setBackground(Color.decode("#8aba56"));
        btnCargarFile.setActionCommand(Actions.OPEN_FILE.name());
        btnCargarFile.addActionListener(Controller.getInstance());

        JButton btnRun = new JButton("Ejecutar", new ImageIcon(getClass().getResource("/Img/play.png")));
//        JButton btnRun = new JButton("Ejecutar", new ImageIcon("src/Img/play.png"));
        btnRun.setBackground(Color.decode("#8aba56"));
        btnRun.setActionCommand(Actions.RUN.name());
        btnRun.addActionListener(Controller.getInstance());

        JButton btnClear = new JButton("Limpiar Todo", new ImageIcon(getClass().getResource("/Img/escoba.png")));
//        JButton btnClear = new JButton("Limpiar Todo", new ImageIcon("src/Img/escoba.png"));
        btnClear.setBackground(Color.decode("#8aba56"));
        btnClear.setActionCommand(Actions.CLEAR.name());
        btnClear.addActionListener(Controller.getInstance());

        pnButtons.setBorder(BorderFactory.createTitledBorder("  "));
        pnButtons.add(btnCargarFile);
        pnButtons.add(btnRun);
        pnButtons.add(btnClear);

        pnCenter.add(pnButtons, BorderLayout.PAGE_START);

        jMenuBarMain = new JMenuBarMain();
        add(jMenuBarMain, BorderLayout.PAGE_START);

        JPanel pnContain = new JPanel();
        pnContain.setLayout(new GridLayout(1, 2));
        panelConsole = new PanelConsola();
        panelEditor = new PanelEditor();
        pnContain.add(panelEditor);
        pnContain.add(panelConsole);

        pnCenter.add(pnContain, BorderLayout.CENTER);

        add(pnCenter, BorderLayout.CENTER);

        setVisible(true);
    }

    private static void designWindow() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getCode() {
        return panelEditor.getCode();
    }

    public static void printInConsole(String printVariables, boolean isError) {
        output += printVariables;
        panelConsole.printInConsole(output, isError);
    }

    public void clearConsole() {
        output = "";
        panelConsole.clearConsole();
    }

    public void clearEditor() {
        panelEditor.clearEditor();
    }

    public void printProgramInEditorDeTexto(String abrirArchivo) {
        panelEditor.printProgramInEditorDeTexto(abrirArchivo);
    }
}
