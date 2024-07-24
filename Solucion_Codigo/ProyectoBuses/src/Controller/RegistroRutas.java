package Controller;

import Model.SistemaBuses;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroRutas extends SistemaBuses {

    Scanner sc = new Scanner(System.in);
    public String horario;
    public String recorrido;
    public final String rutaArchivoInfo = "C:\\Users\\USUARIO\\Documents\\"
            + "proyecto bimestral\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios"
            + "\\documentoInfo.csv";

    public RegistroRutas(String horario, String recorrido, RegistroRutas[] rutas,
            RegistroParadas[] paradas, OptimizacionRutas[] optimizaciones) {
        this.horario = horario;
        this.recorrido = recorrido;
    }

    @Override
    public void menu() {
        int opc;
        try {
            rutas = leerRutas(rutaArchivoInfo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            System.out.println("-----------HORARIOS BUSES------------");
            System.out.println("Ingrese la opcion deseada: ");
            System.out.println("[1] Para Mostrar los horarios de las rutas");
            System.out.println("[2] Para aniadir un nuevo horario");
            System.out.println("[0] Para salir");
            opc = sc.nextInt();
            switch (opc) {
                case 1 ->mostrarHorariosRutas();
                case 2 ->aniadir();
            }
        } while (opc != 0);
    }

    private RegistroRutas[] leerRutas(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        RegistroParadas[] paradas = new RegistroParadas[72];
        int index = 0;
        while (fileIn.hasNextLine() && index < paradas.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                index++;
            }
        }
        return rutas;
    }

    private void mostrarHorariosRutas() {
        System.out.println("============ HORARIOS DE LOS BUSES ===============");
        for (RegistroRutas ruta : rutas) {
            if (ruta != null) {
                System.out.println(horario + " | " + recorrido);
            }
        }
    }

    @Override
    public void aniadir() {
        String a;
        String b;
        System.out.println("----Registro Horario Nuevo-----");
        System.out.println("Ingrese horario de llegada:");
        a=sc.nextLine();
        System.out.println("Ingrese horario de salida:");
        b=sc.nextLine();
        RegistroHorarios aniadir=new RegistroHorarios(a,b); 
    }
}
