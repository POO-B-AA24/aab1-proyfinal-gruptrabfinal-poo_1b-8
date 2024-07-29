package Controller;

import Model.*; // Importa todas las clases del paquete Model
import java.util.Scanner;

// Define la clase Ruta que extiende DatosBuses
public class Ruta extends DatosBuses {

    // Instancia de Scanner para leer entradas del usuario
    Scanner sc = new Scanner(System.in);
    
    // Atributos de la clase Ruta
    private String horario;    // Horario asociado a la ruta
    private String recorrido;  // Recorrido de la ruta

    // Constructor vacío de la clase Ruta
    public Ruta() {
    }

    // Constructor que inicializa los atributos horario y recorrido
    public Ruta(String horario, String recorrido) {
        this.horario = horario;
        this.recorrido = recorrido;
    }

    // Método getter para el atributo horario
    public String getHorario() {
        return horario;
    }

    // Método getter para el atributo recorrido
    public String getRecorrido() {
        return recorrido;
    }

    // Método sobreescrito de la clase base DatosBuses
    @Override
    public void menu() {
        DatosBuses app = new DatosBuses(); // Crea una instancia de DatosBuses
        int opc;
        // Muestra opciones para consultar la optimización de rutas
        System.out.println("Desea consultar una optimizacion?[1]si");
        System.out.println("[0]no");
        // Lee la opción seleccionada por el usuario
        opc = sc.nextInt();
        // Si el usuario elige 1, llama a los métodos iniciar y mostrarHorariosRutas de DatosBuses
        if (opc == 1) {
            app.iniciar();
        } else {
            // Muestra un mensaje de despedida si el usuario elige 0
            System.out.println("Un gusto haber ayudado");
        }
    }
}
