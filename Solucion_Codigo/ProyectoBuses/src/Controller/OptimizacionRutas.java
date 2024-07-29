package Controller;

// Define la clase OptimizacionRutas para manejar la optimización de rutas
public class OptimizacionRutas {
    // Atributos privados de la clase OptimizacionRutas
    private String horas;                // Horarios asociados a la optimización de rutas
    private String paradasRecurrentes;   // Información sobre las paradas recurrentes

    // Constructor de la clase que inicializa los atributos con los valores proporcionados
    public OptimizacionRutas(String horas, String paradasRecurrentes) {
        this.horas = horas;                     // Inicializa el atributo horas
        this.paradasRecurrentes = paradasRecurrentes; // Inicializa el atributo paradasRecurrentes
    }

    // Método getter para el atributo horas
    public String getHoras() {
        return horas; // Devuelve el valor del atributo horas
    }

    // Método getter para el atributo paradasRecurrentes
    public String getParadasRecurrentes() {
        return paradasRecurrentes; // Devuelve el valor del atributo paradasRecurrentes
    }
}
