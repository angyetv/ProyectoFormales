package proyectoformales;

import controllers.Controller;
import views.MainWindow;

public class ProyectoFormales {

    public static void main(String[] args) {
        Controller controlller = Controller.getInstance();
        MainWindow mainWindow = new MainWindow();
        controlller.setMainWindow(mainWindow);
        System.out.println(mainWindow.getPrint());
    }
}
