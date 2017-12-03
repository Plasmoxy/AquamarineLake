import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class App extends Application
{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("gamagui.fxml"));
    Parent guiroot;
    Scene sc;
    Controller contr;


    public void start(Stage stg) throws IOException
    {
        guiroot = loader.load();
        sc = new Scene(guiroot);
        
        contr = loader.getController();

        stg.setScene(sc);
        stg.sizeToScene();
        stg.setTitle("Plasmoxy::ThunderLord/VisionGama");
        stg.setMinHeight(stg.getHeight());
        stg.setMinWidth(stg.getWidth());
        stg.show();
        
        stg.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent event)
            {
                System.out.println("CLOSING");
                contr.close();
            }
        });
        
    }

    public void stop()
    {
        System.out.println("STOPP");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
