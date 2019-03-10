package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDHelp extends JDialog {

    public JDHelp() {
        this.setSize(new Dimension(850, 400));
        this.setTitle("Ayuda");
        this.setBackground(Color.decode("#FFFFFF"));
        this.setLayout(new BorderLayout());
        init();
        this.setVisible(false);
    }

    private void init() {
        this.add(createText(), BorderLayout.NORTH);
        this.add(addImage(), BorderLayout.CENTER);
    }

    private JPanel addImage() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        ImageIcon icon = new ImageIcon(getClass().getResource("/Img/t1.PNG"));
//        ImageIcon icon = new ImageIcon("src/Img/t1.PNG");
        ImageIcon iconoEscala = new ImageIcon(icon.getImage().getScaledInstance(400, -10, java.awt.Image.SCALE_SMOOTH));
        JLabel jLabel = new JLabel(iconoEscala);
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Img/t2.PNG"));
//        ImageIcon icon2 = new ImageIcon("src/Img/t2.PNG");
        ImageIcon iconoEscala2 = new ImageIcon(icon2.getImage().getScaledInstance(400, -10, java.awt.Image.SCALE_SMOOTH));
        jPanel.setBackground(Color.decode("#FFFFFF"));
        jPanel.add(jLabel);
        jPanel.add(new JLabel(iconoEscala2));
        return jPanel;
    }

    private JPanel createText() {
        JPanel jPanel = new JPanel();
        Font font = new Font("Century Schoolbook", Font.BOLD, 20);
        JLabel jLabel = new JLabel(Constants.TITLE2);
        jLabel.setFont(font);
        jPanel.setBackground(Color.decode("#FFFFFF"));
        jPanel.add(jLabel);

        return jPanel;
    }
}
