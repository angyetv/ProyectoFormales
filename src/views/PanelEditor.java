package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author angyedanielatorresveloza
 */
public class PanelEditor extends JPanel {

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

    public ArrayList<String> getCode() {
        System.out.println("entrooo");
        ArrayList<String> codeList = new ArrayList<>();
        String[] parts = jTextArea.getText().split("\\*");
        for (int i = 0; i < parts.length; i++) {
            codeList.add(parts[i]);
        }
        return codeList;
    }
}
