package Controller;

import Model.SistemaBuses;

public class RegistroHorarios extends SistemaBuses {

    public String horaLlegada;
    public String horasSalida;

    public RegistroHorarios(String horaLlegada, String horasSalida) {
        this.horaLlegada = horaLlegada;
        this.horasSalida = horasSalida;
    }
}
