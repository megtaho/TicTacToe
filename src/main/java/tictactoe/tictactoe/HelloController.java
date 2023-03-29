package tictactoe.tictactoe;

import appli.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class HelloController  {


    @FXML
    private Button btnStart;

    @FXML
    private TextField txtJoueurA;

    @FXML
    private TextField txtJoueurA1;

    @FXML
    void onClickStartButton(ActionEvent event) {
        if (txtJoueurA.getText().isEmpty() ||txtJoueurA1.getText().isEmpty()){
            System.out.println("erreur...");
            if(txtJoueurA.getText().isEmpty()){
                System.out.println("txtJoueurA...");

                txtJoueurA.setStyle("-fx-text-box-border: red;");
            }else{
                txtJoueurA.setStyle("");

            }
            if(txtJoueurA1.getText().isEmpty()){
                System.out.println("txtJoueurA1...");

                txtJoueurA1.setStyle("-fx-text-box-border: red;");
            }else{
                txtJoueurA1.setStyle("");

            }
        }else{
            txtJoueurA1.setStyle("");
            txtJoueurA.setStyle("");
            System.out.println("OK ! ");
            HelloApplication.changeScene("/tictactoe/tictactoe/tictactoe",new Tictactoe(txtJoueurA.getText(),txtJoueurA1.getText()));
        }
    }

    @FXML
    void test(MouseEvent event) {
        System.out.println("test");
    }
}
