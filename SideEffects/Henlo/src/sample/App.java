package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    private Main m = Main.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //fxinit
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        System.out.println("INITIALIZED");
        //------

        
        
        
        m.init(this, primaryStage);
        m.go();
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
