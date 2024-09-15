package pe.edu.upeu.tictactoe.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class TictacControl {



    Button[][] tablero;

    @FXML
    Button btn00, btn01, btn02,btn10, btn11, btn12, btn20,btn21, btn22;

    boolean turno=true;

    public static void main(String[] args) {

    }

    @FXML
    public void initialize() {
        System.out.println("holas");
        tablero=new Button[][]{
                {btn00, btn01,btn02},
                {btn10, btn11, btn12},
                {btn20,btn21, btn22}
        };
    }

    @FXML
    void accionButon(ActionEvent e){
        Button b=(Button)e.getSource();
        b.setText(turno?"X":"O");
        turno=!turno;
    }

    @FXML
    void imprimir(){
        for (int i=0;i<tablero.length; i++ ){
            for (int j=0;j<tablero[0].length; j++ ){
                System.out.print(tablero[i][j].getText()+"\t");
            }
            System.out.println("");
        }
    }
    @FXML
    public void iniciar(){
        activaDesacticaB(false);
    }

    @FXML
    public void anular(){
        activaDesacticaB(true);
    }

    public void activaDesacticaB(boolean indi){
        btn00.setDisable(indi);
        btn01.setDisable(indi);
        btn02.setDisable(indi);
        btn10.setDisable(indi);
        btn11.setDisable(indi);
        btn12.setDisable(indi);
        btn20.setDisable(indi);
        btn21.setDisable(indi);
        btn22.setDisable(indi);
    }

}
