package Controller;


public class OptimizacionRutas {
    private String horas;
    private String paradasRecurrentes;

    public OptimizacionRutas(String horas, String paradasRecurrentes) {
        this.horas = horas;
        this.paradasRecurrentes = paradasRecurrentes;
    }

    public String getHoras() {
        return horas;
    }

    public String getParadasRecurrentes() {
        return paradasRecurrentes;
    }
}
