package views;

import controllers.Constants;
import controllers.Controller;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
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
    private PanelConsola panelConsole;
    private PanelEditor panelEditor;
    
    public MainWindow() {
        designWindow();
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        
        JPanel pnButtons = new JPanel();
        pnButtons.setLayout(new GridLayout(1, 2));
        JButton btnRun = new JButton("Run");
        btnRun.setActionCommand(Constants.RUN.name());
        btnRun.addActionListener(Controller.getInstance());
        JButton btnClear = new JButton("Limpiar");
        pnButtons.setBorder(BorderFactory.createTitledBorder("  "));
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
}
