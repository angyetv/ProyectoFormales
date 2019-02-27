package views;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new GridLayout(1,2));
        
        jMenuBarMain = new JMenuBarMain();
        add(jMenuBarMain, BorderLayout.PAGE_START);
        
        panelConsola = new PanelConsola();
        panelEditor = new PanelEditor();
        pnCenter.add(panelConsola);
        pnCenter.add(panelEditor);
        
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
