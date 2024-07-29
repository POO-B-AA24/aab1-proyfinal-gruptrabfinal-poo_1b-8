package Controller;

import Model.Usuarios;

// Define la clase PersonalUtpl que extiende la clase Usuarios
public class PersonalUtpl extends Usuarios {
    int antiguedad;
    // Constructor de la clase PersonalUtpl que inicializa nombre y edad
    public PersonalUtpl(String nombre, int edad) {
        super(nombre, edad); // Llama al constructor de la clase base Usuarios
    }
    
    // Método menu sobreescrito de la clase base Usuarios
    @Override
    public void menu() {
        // Implementación vacía; puede ser completada más tarde
    }
}
