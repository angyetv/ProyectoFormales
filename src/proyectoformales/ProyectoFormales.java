package proyectoformales;

import controllers.Controller;
import models.LexiconAnalyzerAdministrator;
import models.SyntacticAnalyzer;
import views.JDAboutOf;
import views.JDHelp;
import views.MainWindow;

public class ProyectoFormales {

    public static void main(String[] args) {
        Controller controlller = Controller.getInstance();
        MainWindow mainWindow = new MainWindow();
        LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator = new LexiconAnalyzerAdministrator();
        SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
        JDAboutOf jDAboutOf = new JDAboutOf();
        JDHelp jDHelp = new JDHelp();
        controlller.setMainWindow(mainWindow);
        controlller.setLexiconAnalyzerAdministrator(lexiconAnalyzerAdministrator);
        controlller.setSyntacticAnalyzer(syntacticAnalyzer);
        controlller.setjDAboutOf(jDAboutOf);
        controlller.setjDHelp(jDHelp);
    }
}
