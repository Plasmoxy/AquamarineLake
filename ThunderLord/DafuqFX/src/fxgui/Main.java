package fxgui;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;

import java.util.concurrent.CountDownLatch;

public class Main
{
    // singleton
    private static Main main = new Main();
    private Main() {}
    public static Main getInstance() { return main; }
    
    // references and stuff
    public App app;
    public Scene sc;
    
    private JFXButton blyat;

    private static void run()
    {
    }

    // initialization
    public void init(App a, Scene s)
    {
        app = a;
        sc = s;
        
        blyat = (JFXButton) sc.lookup("#blyat");
    }
    
    // main method
    public void go() throws InterruptedException
    {
        
    }
    
}
