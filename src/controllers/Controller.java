package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import models.LexiconAnalyzerAdministrator;
import models.SyntacticAnalyzer;
import views.JDAboutOf;
import views.JDHelp;
import views.MainWindow;

/**
 *
 * @author angyedanielatorresveloza
 */
public class Controller implements ActionListener {

    private static Controller controller = null;
    private MainWindow mainWindow;
    private LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator;
    private SyntacticAnalyzer syntacticAnalyzer;
    private JDAboutOf jDAboutOf;
    private JDHelp jDHelp;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Actions.valueOf(e.getActionCommand())) {
            case RUN:
                runCode();
                break;
            case CLEAR:
                mainWindow.clearEditor();
                mainWindow.clearConsole();
                break;
            case HELP: 
                jDHelp.setLocationRelativeTo(mainWindow);
                jDHelp.setVisible(true);
                break;
            case EXIT:
                System.exit(0);
                break;
            case ABOUT_OF:
                jDAboutOf.setLocationRelativeTo(mainWindow);
                jDAboutOf.setVisible(true);
                break;
            case CLEAR_CONSOLE:
                mainWindow.clearConsole();
                break;
             case OPEN_FILE:
                mainWindow.printProgramInEditorDeTexto(abrirArchivo());
                break;
        }
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private void runCode() {
        lexiconAnalyzerAdministrator.setLines(mainWindow.getCode());
        String lexiconOutput = lexiconAnalyzerAdministrator.printLexicon();
        if (lexiconOutput.contains("Error Lexico en la linea ")) {
            MainWindow.printInConsole(lexiconOutput, true);
        } else {
            MainWindow.printInConsole(lexiconOutput, false);
        }
        mainWindow.printInConsole(syntacticAnalyzer.validateProgram(lexiconAnalyzerAdministrator.getToSyntactic()), false);
        syntacticAnalyzer.setCountLine(1);
        lexiconAnalyzerAdministrator.getLinesList().clear();
        lexiconAnalyzerAdministrator.setTOKEN(0);

    }

    /**
     * Abre y carga el programa
     * @return 
     */
    private String abrirArchivo() {
        String aux = "";
        String texto = "";
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(mainWindow);
            File abre = file.getSelectedFile();
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                System.out.println("entroo");
                while ((aux = lee.readLine()) != null) {
                    texto += aux + "\n";
                    System.out.println(texto);
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public void setLexiconAnalyzerAdministrator(LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator) {
        this.lexiconAnalyzerAdministrator = lexiconAnalyzerAdministrator;
    }

    public void setSyntacticAnalyzer(SyntacticAnalyzer syntacticAnalyzer) {
        this.syntacticAnalyzer = syntacticAnalyzer;
    }

    public LexiconAnalyzerAdministrator getLexiconAnalyzerAdministrator() {
        return lexiconAnalyzerAdministrator;
    }

    public JDAboutOf getjDAboutOf() {
        return jDAboutOf;
    }

    public void setjDAboutOf(JDAboutOf jDAboutOf) {
        this.jDAboutOf = jDAboutOf;
    }

    public JDHelp getjDHelp() {
        return jDHelp;
    }

    public void setjDHelp(JDHelp jDHelp) {
        this.jDHelp = jDHelp;
    }
}
