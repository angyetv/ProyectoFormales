package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author angyedanielatorresveloza
 */
public class MainWindow extends JFrame {

    private JMenuBarMain jMenuBarMain;
    private PanelConsola panelConsola;
    private PanelEditor panelEditor;

    public MainWindow() {
        designWindow();
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());

        JPanel pnBotones = new JPanel();
        pnBotones.setLayout(new GridLayout(1, 2));
        JButton btnCorrer = new JButton("Run");
        JButton btnLimpiar = new JButton("Limpiar");
        pnBotones.setBorder(BorderFactory.createTitledBorder("  "));
        pnBotones.add(btnCorrer);
        pnBotones.add(btnLimpiar);

        pnCenter.add(pnBotones, BorderLayout.PAGE_START);

        jMenuBarMain = new JMenuBarMain();
        add(jMenuBarMain, BorderLayout.PAGE_START);

        JPanel pnContenido = new JPanel();
        pnContenido.setLayout(new GridLayout(1, 2));
        panelConsola = new PanelConsola();
        panelEditor = new PanelEditor();
        pnContenido.add(panelEditor);
        pnContenido.add(panelConsola);
        
        pnCenter.add(pnContenido, BorderLayout.CENTER);

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
}
