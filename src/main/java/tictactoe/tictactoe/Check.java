package tictactoe.tictactoe;

import appli.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Check implements Initializable {

    private String joueurA;
    private String joueurB;
    private String  estJoueurAGangnant;

    @FXML
    private Label lblMessage;
    public Check(String joueurA, String joueurB, String estJoueurAGangnant) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.estJoueurAGangnant = estJoueurAGangnant;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (this.estJoueurAGangnant == this.joueurA) {
            this.lblMessage.setText("Bravo " + this.joueurA + "! Tu as gagné");
        } else if (this.estJoueurAGangnant == this.joueurB) {
            this.lblMessage.setText("Bravo " + this.joueurB + "! Tu as gagné");
        } else {
            this.lblMessage.setText("match nul");
        }
    }

    public void newGameAction(ActionEvent event){
        HelloApplication.changeScene("/tictactoe/tictactoe/tictactoe",new Tictactoe(this.joueurB,this.joueurA));
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    public void accueilAction(ActionEvent event){
        HelloApplication.changeScene("/tictactoe/tictactoe/joueur");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
