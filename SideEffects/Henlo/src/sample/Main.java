package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Main // uses singleton pattern
{
    
    private static Main instance;
    private Main() {} // block instantiation
    static { instance = new Main(); } // instantiate singleton object

    public static Main getInstance()
    {
        return instance;
    }
    
    private Stage stage;
    private Application app;
    public void init(Application a, Stage s)
    {
        stage = s;
        app = a;
    }
    
    public Printer prnt = new Printer();
    
    public void go()
    {
        prnt.print();
    }
    
    
}
