import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.opencv.core.Core;

import java.io.IOException;

public class App extends Application
{
    
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    
    @Override
    public void start(Stage s) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        BorderPane root = (BorderPane) loader.load();
        Controller contr = loader.getController();
        
        Scene sc = new Scene(root, 600, 400);
        s.setScene(sc);
        s.setTitle("ThunderLord/VisionAlpha");
        s.setResizable(false);
        s.sizeToScene();
        s.show();

        s.setOnCloseRequest((new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we)
            {
                
            }
        }));
        
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
