package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainWindow;

/**
 *
 * @author angyedanielatorresveloza
 */
public class Controller implements ActionListener {

    private static Controller controller = null;
    private MainWindow mainWindow;

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
        System.out.println(mainWindow.getPrint());
    }
}
