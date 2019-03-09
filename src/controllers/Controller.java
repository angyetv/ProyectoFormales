package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                jDHelp.setVisible(true);
                break;
            case EXIT:
                System.exit(0);
                break;
            case ABOUT_OF:
                jDAboutOf.setVisible(true);
                break;
            case CLEAR_CONSOLE:
                mainWindow.clearConsole();
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
