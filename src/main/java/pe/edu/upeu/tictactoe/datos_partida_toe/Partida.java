package pe.edu.upeu.tictactoe.datos_partida_toe;

public class Partida {
    private String estado;
    private int puntaje;
    private String ganador;
    private String jugador1;
    private String jugador2;

    public Partida(String estado, int puntaje, String ganador, String jugador2) {
        this.estado = estado;
        this.puntaje = puntaje;
        this.ganador = ganador;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
}