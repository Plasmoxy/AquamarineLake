package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    
    Main m = Main.getInstance();
    
    @FXML JFXButton butt;
    
    @FXML protected void handlebutt(ActionEvent e)
    {
        m.prnt.print();
    }
    
}
