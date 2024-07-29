package Model;

import Controller.*; // Importa todas las clases del paquete Controller
import java.util.Scanner;

// Define la clase Usuarios para gestionar la información y el tipo de usuario
public class Usuarios {
DatosBuses app=new DatosBuses();
    // Instancia de Scanner para leer entradas del usuario
    Scanner sc = new Scanner(System.in);
    
    // Atributos para almacenar el nombre y la edad del usuario
    String nombre;
    int edad;

    // Constructor vacío
    public Usuarios() {
    }

    // Constructor que inicializa el nombre y la edad
    public Usuarios(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para gestionar el menú de selección del tipo de usuario
    public void menu() {
        int num;
        String msj;
        
        // Solicita el nombre y la edad del usuario
        System.out.println("Ingrese su nombre:");
        nombre = sc.nextLine();
        System.out.println("Ingrese su edad:");
        edad = sc.nextInt();
        
        // Solicita al usuario que seleccione el tipo de usuario
        System.out.println("Por favor, ingrese el tipo de usuario que es:");
        System.out.println("[1] Estudiante");
        System.out.println("[2] Personal Utpl");
        System.out.println("[3] Externo");
        num= sc.nextInt();
        
        // Controla la selección del tipo de usuario
        switch (num) {
            case 1 -> {
                // Crea una instancia de Estudiante y llama a su menú
                Estudiante est = new Estudiante(nombre, edad);
                est.menu();
                msj=est.toString();
                System.out.println(msj);
                app.menu();
                
                // Se añadió 'break' para evitar que el código continúe a los siguientes casos
            }
            case 2 -> {
                // Crea una instancia de PersonalUtpl y llama a su menú
                PersonalUtpl prnal = new PersonalUtpl(nombre, edad);
                prnal.menu();
                // Se añadió 'break' para evitar que el código continúe a los siguientes casos
            }
            case 3 -> {
                // Crea una instancia de Externo y llama a su menú
                Externo ex = new Externo(nombre, edad);
                ex.menu();
                // Se añadió 'break' para evitar que el código continúe a los siguientes casos
            }
            default -> // Mensaje de error si la opción no es válida
                System.out.println("Opción no válida.");
        }
    }
}
