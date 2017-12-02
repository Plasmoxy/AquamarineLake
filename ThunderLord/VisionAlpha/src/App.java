import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
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
    
    public FXMLLoader loader;
    public BorderPane root;
    public Controller contr;
    public Scene sc;
    public Stage st;
    
    @Override
    public void start(Stage s) throws IOException
    {
        loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        root = (BorderPane) loader.load();
        contr = loader.getController();
        contr.link(this);
        st = s;
        
        sc = new Scene(root, 600 ,600);
        s.setMinWidth(600);
        s.setMinHeight(600);
        s.setScene(sc);
        s.setTitle("ThunderLord/VisionAlpha");
        s.sizeToScene();
        s.show();

        s.setOnCloseRequest((new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we)
            {
                System.out.println("CLOSING");
                contr.setClosed();
            }
        }));
        
    }

    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch(args);
        System.out.println("EXIT");
    }
    
}
