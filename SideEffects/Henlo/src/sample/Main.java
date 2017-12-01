package sample;

import javafx.application.Application;
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
    
    
}
