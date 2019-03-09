package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDHelp extends JDialog {

    public JDHelp() {
        this.setSize(new Dimension(700, 500));
        this.setTitle("Ayuda");
        this.setBackground(Color.decode("#FFFFFF"));
        init();
        this.setVisible(false);
    }

    private void init() {
        this.add(addImage());
        //this.add(createText(), BorderLayout.CENTER);
    }

    private JPanel addImage() {
        JPanel jPanel = new JPanel();
        ImageIcon icon = new ImageIcon("src/Img/help.PNG");
        ImageIcon iconoEscala = new ImageIcon(icon.getImage().getScaledInstance(560, -10, java.awt.Image.SCALE_SMOOTH));
        JLabel jLabel = new JLabel(iconoEscala);
        jPanel.setBackground(Color.decode("#FFFFFF"));
        jPanel.add(jLabel);
        return jPanel;
    }

    private JPanel createText() {
        JPanel jPanel = new JPanel();
        Font font = new Font("Century Schoolbook", Font.BOLD, 20);
        JLabel jLabel = new JLabel(Constants.TITLE);
        JLabel jLabel1 = new JLabel(Constants.MESSAGE);
        Font font2 = new Font("Century Schoolbook", Font.BOLD, 15);
        jLabel1.setFont(font2);
        jLabel.setFont(font);
        jPanel.setBackground(Color.decode("#FFFFFF"));
        jPanel.add(jLabel);
        jPanel.add(jLabel1);

        return jPanel;
    }
}
