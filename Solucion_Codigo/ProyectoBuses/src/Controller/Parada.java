package Controller;

import Model.DatosBuses;
import java.util.Scanner;

// Define la clase Parada que extiende la clase DatosBuses
public class Parada extends DatosBuses {

    // Atributos privados de la clase Parada
    private String nombre;      // Nombre de la parada
    private String ubicacion;  // Ubicación de la parada
    private Scanner sc = new Scanner(System.in); // Instancia de Scanner para entrada de datos

    // Constructor vacío de la clase Parada
    public Parada() {
    }

    // Constructor que inicializa los atributos nombre y ubicacion
    public Parada(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    // Método getter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    // Método getter para el atributo ubicacion
    public String getUbicacion() {
        return ubicacion;
    }

    // Método sobreescrito de la clase base DatosBuses
    @Override
    public void menu() {
        int opc;
        // Crea una instancia de DatosBuses para llamar su método menu
        DatosBuses app = new DatosBuses();
        // Muestra un mensaje para consultar si el usuario desea hacer otra consulta
        System.out.println("Desea Consultar algo mas?");
        System.out.println("Si[1]/No[0]");
        // Lee la opción ingresada por el usuario
        opc = sc.nextInt();
        // Si el usuario ingresa 1, llama al método menu de DatosBuses
        if (opc == 1) {
            app.menu();
        } else {
            // Si el usuario ingresa 0, muestra un mensaje de despedida
            System.out.println("Un gusto haberlo ayudado");
        }
    }
}
