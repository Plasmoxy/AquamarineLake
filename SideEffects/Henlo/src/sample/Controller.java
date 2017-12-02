package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
    
    Main m = Main.getInstance();
    
    @FXML JFXButton butt;
    @FXML Text numberText;
    
    @FXML protected void handlebutt(ActionEvent e)
    {
        numberText.setText(Double.toString(Math.random()));
    }
    
}
