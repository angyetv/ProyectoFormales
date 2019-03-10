package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDAboutOf extends JDialog {

    public JDAboutOf() {
      ImageIcon imageIcon = new ImageIcon("src/Img/LOGO.PNG");
        Image image = imageIcon.getImage();
        this.setIconImage(image);
        this.setSize(500, 700);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#FFFFFF"));
        this.setTitle("Acerca de");
        init();
        this.setVisible(false);
    }

    private void init() {
        this.add(addImage(), BorderLayout.NORTH);
        this.add(createText(), BorderLayout.CENTER);
    }

    private JPanel addImage() {
        JPanel jPanel = new JPanel();
        ImageIcon icon = new ImageIcon("src/img/LOGO.PNG");
        ImageIcon iconoEscala = new ImageIcon(icon.getImage().getScaledInstance(230, -10, java.awt.Image.SCALE_SMOOTH));
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
