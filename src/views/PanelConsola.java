package views;

import controllers.Actions;
import controllers.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author angyedanielatorresveloza
 */
public class PanelConsola extends JPanel {

    private final JTextArea jTextArea;

    public PanelConsola() {
        setBackground(Color.decode("#f0f0f0"));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("   "));
        JLabel lbTitulo = new JLabel("Analisis Sintactico y Lexico");
        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbTitulo.setForeground(Color.decode("#be0027"));
        add(lbTitulo, BorderLayout.PAGE_START);

        jTextArea = new JTextArea("");
        jTextArea.setEditable(false);
        JPopupMenu popup = new JPopupMenu();
        jTextArea.add(popup);
        jTextArea.setComponentPopupMenu(popup);
        JMenuItem subMenu = new JMenuItem("Limpiar Consola");
        subMenu.addActionListener(Controller.getInstance());
        subMenu.setActionCommand(Actions.CLEAR_CONSOLE.name());
        popup.add(subMenu);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        jScrollPane.setAutoscrolls(true);
        add(jScrollPane, BorderLayout.CENTER);

    }

    public void printInConsole(String printVariables, boolean isError) {
        jTextArea.setForeground(Color.black);
        if (isError) {
            jTextArea.setForeground(Color.red);
        }
        jTextArea.setText(printVariables);
    }

    public void clearConsole() {
        jTextArea.setText("");
    }
}