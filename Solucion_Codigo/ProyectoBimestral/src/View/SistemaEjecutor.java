package View;
import Controller.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class SistemaEjecutor {
    public static GestionRutas gestion = new GestionRutas();
    public static final String Datos = "C:\\Users\\julio\\OneDrive\\Escritorio\\datos.txt";
    public static void main(String[] args) {
        gestion.cargarDatos(Datos);
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("---------BUSES UTPL--------");
            System.out.println("Indicar la opcion requerida\n"
                    + "REGISTRO---------------------------\n"
                    + "Ingresar para Registrar Parada  [1]\n"
                    + "Ingresar para Registrar Horario [2]\n"
                    + "Ingresar para Registrar Ruta    [3]\n"
                    + "Ingresar para Registrar Usuario [4]\n"
                    + "CONSULTAS--------------------------\n"
                    + "Ingresar para Consultar Paradas [5]\n"
                    + "Ingresar para Consultar Rutas   [6]\n"
                    + "Ingresar para Consultar Usuarios[7]\n"
                    + "Ingresar para Salir             [0]");
            int op = leer.nextInt();
            leer.nextLine();
            switch (op) {
                case 1:
                    registroParada(leer);
                    break;
                case 2:
                    registroHorario(leer);
                    break;
                case 3:
                    registroRuta(leer);
                    break;
                case 4:
                    regUsuario(leer);
                    break;
                case 5:
                    consultarParadas();
                    break;
                case 6:
                    consultarRutas();
                    break;
                case 7:
                    consultarUsuarios();
                    break;
                case 0:
                    gestion.guardarDatos(Datos);
                    salir = true;
                    break;
                default:
                    System.out.println("opcion ingresada incorrecta");
            }
        }
    }
    public static void registroParada(Scanner sc) {
        String nombre,ubicacion;
        int Npa;
        System.out.print("Nombre de la parada del bus: ");
        nombre = sc.nextLine();
        System.out.print("Número de parada: ");
        Npa = sc.nextInt();
        sc.nextLine();
        System.out.print("Ubicación: ");
        ubicacion = sc.nextLine();
        
        RegistroParadas parada = new RegistroParadas(nombre, Npa, ubicacion);
        gestion.regParada(parada);
        System.out.println("Guardado");
    }

    public static void registroHorario(Scanner sc) {
        int Npa;
        System.out.print("Número de parada: ");
        Npa = sc.nextInt();
        sc.nextLine();
        System.out.print("Hora de salida (Horas:Minutos): ");
        LocalTime horaSalida = LocalTime.parse(sc.nextLine());
        System.out.print("Hora de entrada (Horas:Minutos): ");
        LocalTime horaEntrada = LocalTime.parse(sc.nextLine());
        RegistroHorarios horario = new RegistroHorarios(Npa, horaSalida, horaEntrada);
        for (RegistroParadas parada : gestion.consultaParada()) {
            if (parada.Npa() == Npa) {
                parada.setHorario(horario);
                break;
            }
        }
        System.out.println("Guardado Correctamente.");
    }
    
    public static void registroRuta(Scanner sc) {
        int Npa;
        String nombre;
        System.out.print("Número de ruta: ");
        Npa = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre de la ruta: ");
        nombre = sc.nextLine();
        OptimizacionRutas ruta = new OptimizacionRutas(Npa, nombre);
        gestion.regRuta(ruta);
        System.out.println("Guardado Correctamente.");
    }

    public static void regUsuario(Scanner sc) {
        int Npa;
        String nombre,email,tipoUsuario;
        System.out.print("Número de usuario: ");
        Npa = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();
        System.out.print("Tipo de usuario: ");
        tipoUsuario = sc.nextLine();
        InterfazUsuario usuario = new InterfazUsuario(Npa, nombre, email, tipoUsuario);
        gestion.regUsuario(usuario);
        System.out.println("Guardado Correctamente.");
    }

    public static void consultarParadas() {
        List<RegistroParadas> paradas = gestion.consultaParada();
        if (paradas.isEmpty()) {
            System.out.println("No se encuentran Paradas registradas");
        } else {
            paradas.forEach(System.out::println);
        }
    }

    public static void consultarRutas() {
        List<OptimizacionRutas> rutas = gestion.consultaRuta();
        if (rutas.isEmpty()) {
            System.out.println("No se encuentran Rutas registradas");
        } else {
            rutas.forEach(System.out::println);
        }
    }

    public static void consultarUsuarios() {
        List<InterfazUsuario> usuarios = gestion.consultaUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No se encuentran Usuarios Registrados");
        } else {
            usuarios.forEach(System.out::println);
        }
    }
}