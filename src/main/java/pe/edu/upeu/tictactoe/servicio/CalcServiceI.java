package pe.edu.upeu.tictactoe.servicio;

import pe.edu.upeu.tictactoe.modelo.CalcTO;
import java.util.List;

public interface CalcServiceI {

    public void guardarResultados(CalcTO to);//C
    public List<CalcTO> obtenerResultados();//R
    public void actualizarResultados(CalcTO to, int index);//U
    public void eliminarResultados(int index);//D


}
