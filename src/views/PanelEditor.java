package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author angyedanielatorresveloza
 */
public class PanelEditor extends JPanel{

    private JTextArea jTextArea;

    public PanelEditor() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("   "));
        jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        jScrollPane.setAutoscrolls(true);
        add(jScrollPane, BorderLayout.CENTER);
    }
}
