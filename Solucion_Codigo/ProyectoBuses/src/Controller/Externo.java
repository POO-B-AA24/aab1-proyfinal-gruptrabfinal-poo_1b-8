package Controller;

// Importa la clase Usuarios desde el paquete Model
import Model.Usuarios;

// Define la clase Externo que extiende la clase Usuarios
public class Externo extends Usuarios {

    // Constructor de la clase Externo que recibe nombre y edad
    public Externo(String nombre, int edad) {
        // Llama al constructor de la clase base Usuarios
        super(nombre, edad);
    }

    // Método menu de la clase Externo
    public void menu() {
        // Implementación vacía
    }
}
