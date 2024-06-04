package Controller;

public class Ruta {
    private String horario;
    private String recorrido;

    public Ruta(String horario, String recorrido) {
        this.horario = horario;
        this.recorrido = recorrido;
    }

    public String getHorario() {
        return horario;
    }

    public String getRecorrido() {
        return recorrido;
    }
}
