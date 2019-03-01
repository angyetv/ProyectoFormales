package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author angyedanielatorresveloza
 */
public class PanelConsola extends JPanel {

    private final JTextArea jTextArea;
    
    public PanelConsola() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("   "));
        JLabel lbTitulo = new JLabel("Analisis Sintactico y Lexico");
        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbTitulo.setForeground(Color.decode("#be0027"));
        add(lbTitulo, BorderLayout.PAGE_START);
        
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        jScrollPane.setAutoscrolls(true);
        add(jScrollPane, BorderLayout.CENTER);
    }
}
