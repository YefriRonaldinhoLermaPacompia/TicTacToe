package pe.edu.upeu.tictactoe.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Node;
import org.springframework.stereotype.Component;
import pe.edu.upeu.tictactoe.datos_partida_toe.Partida;

import java.util.ArrayList;

@Component
public class TictacControl {

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    @FXML
    Button iniciarBtn, anularBtn;
    @FXML
    TableView<Partida> tableView;
    @FXML
    TableColumn<Partida, String> colEstado;
    @FXML
    TableColumn<Partida, String> colGanador;
    @FXML
    TextField tfJugador1, tfJugador2, tfTurno;

    Button[][] tablero;
    boolean turno = true;
    int movimientos = 0;
    ArrayList<Partida> partidas = new ArrayList<>();
    Partida partidaActual;
    int xScore = 0, oScore = 0;

    @FXML
    public void initialize() {
        tablero = new Button[][]{{btn00, btn01, btn02}, {btn10, btn11, btn12}, {btn20, btn21, btn22}};
        anular();
        setupTableView();
    }

    @FXML

    void accionButon(ActionEvent e) {
        Button b = (Button) e.getSource();
        System.out.println("se preciono boton");
        if (b.getText().isEmpty()) {
            b.setText(turno ? "X" : "O");
            movimientos++;
            if (verificarGanador()) {
                String ganador = turno ? "X" : "O";
                mostrarGanador(ganador);
                actualizarPartida(ganador);
                anular();
            } else if (movimientos == 9) {
                mostrarEmpate();
                actualizarPartida(null);
                anular();
            }
            turno =!turno;
        }

    }


    @FXML

    private void actualizarPartida(String ganador) {
        if (partidaActual != null) {
            partidaActual.setEstado("Finalizada");
            partidaActual.setGanador(ganador != null ? ganador : "Empate");
            actualizarTabla();
        }
    }


    private boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].getText().equals(tablero[i][1].getText()) && tablero[i][1].getText().equals(tablero[i][2].getText()) && !tablero[i][0].getText().isEmpty()) {
                actualizarBaseDeDatos(turno ? "X" : "O");
                return true;
            }
            if (tablero[0][i].getText().equals(tablero[1][i].getText()) && tablero[1][i].getText().equals(tablero[2][i].getText()) && !tablero[0][i].getText().isEmpty()) {
                actualizarBaseDeDatos(turno ? "X" : "O");
                return true;
            }
        }
        if (tablero[0][0].getText().equals(tablero[1][1].getText()) && tablero[1][1].getText().equals(tablero[2][2].getText()) && !tablero[0][0].getText().isEmpty()) {
            actualizarBaseDeDatos(turno ? "X" : "O");
            return true;
        }
        if (tablero[0][2].getText().equals(tablero[1][1].getText()) && tablero[1][1].getText().equals(tablero[2][0].getText()) && !tablero[0][2].getText().isEmpty()) {
            actualizarBaseDeDatos(turno ? "X" : "O");
            return true;
        }
        return false;
    }

    private void mostrarGanador(String ganador) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ganador");
        alert.setHeaderText(null);
        alert.setContentText("¡El ganador es " + ganador + "!");
        alert.showAndWait();
    }

    private void mostrarEmpate() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Empate");
        alert.setHeaderText(null);
        alert.setContentText("¡Es un empate!");
        alert.showAndWait();
    }

    @FXML
    public void iniciar(ActionEvent e) {
        movimientos = 0;
        turno = true;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j].setDisable(false);
                tablero[i][j].setText("");
            }
        }
        iniciarBtn.setDisable(true);
        partidaActual = new Partida("Jugando", 0, "", "");
        partidas.add(partidaActual);
        actualizarTabla();
    }

    @FXML
    public void anular() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j].setDisable(true);
                tablero[i][j].setText("");
            }
        }
        iniciarBtn.setDisable(false);

    }

    private void actualizarBaseDeDatos(String ganador) {
        partidaActual.setEstado("Ganado");
        partidaActual.setGanador(ganador);
        if (ganador.equals("X")) xScore++;
        else oScore++;
        actualizarTabla();
    }

    private void setupTableView() {
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colGanador.setCellValueFactory(new PropertyValueFactory<>("ganador"));
        tableView.setItems(javafx.collections.FXCollections.observableArrayList(partidas));
    }

    private void actualizarTabla() {
        tableView.setItems(javafx.collections.FXCollections.observableArrayList(partidas));
    }
}