package proyectoformales;

import controllers.Controller;
import models.LexiconAnalyzerAdministrator;
import models.SyntacticAnalyzerAdministrator;
import views.MainWindow;

public class ProyectoFormales {

    public static void main(String[] args) {
        Controller controlller = Controller.getInstance();
        MainWindow mainWindow = new MainWindow();
        LexiconAnalyzerAdministrator lexiconAnalyzerAdministrator = new LexiconAnalyzerAdministrator();
        SyntacticAnalyzerAdministrator syntacticAnalyzerAdministrator = new SyntacticAnalyzerAdministrator();
        controlller.setMainWindow(mainWindow);
        controlller.setLexiconAnalyzerAdministrator(lexiconAnalyzerAdministrator);
        controlller.setSyntacticAnalyzerAdministrator(syntacticAnalyzerAdministrator);
    }
}
