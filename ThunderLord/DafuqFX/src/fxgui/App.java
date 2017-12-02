package fxgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application
{
    
    public Scene guisc;
    public Parent root;
    
    @Override
    public void start(Stage s) throws IOException
    { 
        root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        guisc = new Scene(root, 600, 400);
        s.setScene(guisc);
        s.setTitle("XD");
        s.setResizable(false);
        s.sizeToScene();
        s.show();
    }
    
    @Override
    public void stop()
    {
        System.out.println("STOPP");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
