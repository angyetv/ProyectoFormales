package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.LexiconAnalyzerAdministrator;
import models.SyntacticAnalyzerAdministrator;
import views.MainWindow;

/**
 *
 * @author angyedanielatorresveloza
 */
public class Controller implements ActionListener {

    private static Controller controller = null;
    private MainWindow mainWindow;
    private LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator;
    private SyntacticAnalyzerAdministrator syntacticAnalyzerAdministrator;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Constants.valueOf(e.getActionCommand())) {
            case RUN:
                runCode();
                break;
            case CLEAR:

                break;
            case HELP:

                break;
            case EXIT:

                break;
            case ABOUT_OF:

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
        lexiconAnalyzerAdministrator.print();
    }

    public void setLexiconAnalyzerAdministrator(LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator) {
        this.lexiconAnalyzerAdministrator = lexiconAnalyzerAdministrator;
    }

    public void setSyntacticAnalyzerAdministrator(SyntacticAnalyzerAdministrator syntacticAnalyzerAdministrator) {
        this.syntacticAnalyzerAdministrator = syntacticAnalyzerAdministrator;
    }

    public LexiconAnalyzerAdministrator getLexiconAnalyzerAdministrator() {
        return lexiconAnalyzerAdministrator;
    }

    public SyntacticAnalyzerAdministrator getSyntacticAnalyzerAdministrator() {
        return syntacticAnalyzerAdministrator;
    }
}
