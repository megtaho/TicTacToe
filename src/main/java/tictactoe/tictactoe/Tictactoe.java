package tictactoe.tictactoe;

import appli.HelloApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Tictactoe implements Initializable {
    private String joueurA;
    private String joueurB;
    private int nbCoup;
    private String marque = "X";
    private int[][][] testVictoire = {
            {
                    {0,0}, {0,1}, {0,2},
            },
            {
                    {1,0}, {1,1}, {1,2},
            },
            {
                    {2,0}, {2,1}, {2,2},
            },
            {
                    {0,0}, {1,0}, {2,0},
            },
            {
                    {0,1}, {1,1}, {2,1},
            },
            {
                    {0,2}, {1,2}, {2,2},
            },
            {
                    {0,0}, {1,1}, {2,2},
            },
            {
                    {0,2}, {1,1}, {2,0},
            },
    };

    private ObservableList<String> coups;

    @FXML
    private GridPane maGrid;

    @FXML
    private Label lblJoueur;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private ListView<String> listCoup;


    public Tictactoe(String joueurA, String joueurB) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        System.out.println(joueurA);
        System.out.println(joueurB);
        listCoup = new ListView<>();
        nbCoup = 0;
    }

    @FXML
    void onClickLabel(MouseEvent event) {
        Label node = (Label) event.getSource();
        if(node.getText().isEmpty()){
            int colonne = GridPane.getColumnIndex(node);
            int ligne = GridPane.getRowIndex(node);
            listCoup.getItems().add(lblJoueur.getText()+" a joué en "+ligne+":"+colonne);
            node.setText(marque);

            System.out.println(checkVictoire());
            //condition de victoire
            if(checkVictoire()){
                System.out.println("youhou !!!");
                HelloApplication.newStage("/tictactoe/tictactoe/check",new Check(this.joueurA,this.joueurB, this.lblJoueur.getText() ));
                panePrincipal.setDisable(true);

            } else if (nbCoup==8) {
                HelloApplication.newStage("/tictactoe/tictactoe/check",new Check(this.joueurA,this.joueurB, null) );
                panePrincipal.setDisable(true);

            }

            nbCoup++;
            marque = (marque.equals("X"))? "O" : "X";
            lblJoueur.setText(
                    (lblJoueur.getText().equals(this.joueurA))? this.joueurB : this.joueurA
            );
            System.out.println(maGrid.getChildren().contains(node));
        }else{
            listCoup.getItems().add(lblJoueur.getText()+" a fait une erreur");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblJoueur.setText(joueurA);

    }
    private boolean checkVictoire(){
        for(int i = 0 ; i < testVictoire.length ; i++){
                if (getNodeFromGridPane(testVictoire[i][0][0],testVictoire[i][0][1]).getText().equals(this.marque) &&
            getNodeFromGridPane(testVictoire[i][1][0],testVictoire[i][1][1]).getText().equals(this.marque) &&
            getNodeFromGridPane(testVictoire[i][2][0],testVictoire[i][2][1]).getText().equals(this.marque)
                )
                    return true;
        }
        return false;
    }

    private Label getNodeFromGridPane( int col, int row) {
        for (Node node : maGrid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return (Label)node;
            }
        }
        return null;
    }
}
