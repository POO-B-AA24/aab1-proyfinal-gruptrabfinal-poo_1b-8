package Model;
import Controller.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

public class Datos {
public void cargarDatos(String nombreArchivo) {
    try (Scanner sc = new Scanner(new File(nombreArchivo))) {
        RegistroParadas currentParada = null;
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] data = linea.split(",");
            switch (data.length) {
                case 3:
                    RegistroParadas parada = new RegistroParadas(data[0], Integer.parseInt(data[1]), data[2]);
                    parada.add(parada);
                    currentParada = parada;
                    break;
                case 4:
                    InterfazUsuario usuario = new InterfazUsuario(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                    usuario.add(usuario);
                    break;
                case 2: 
                    OptimizacionRutas ruta = new OptimizacionRutas(Integer.parseInt(data[0]), data[1]);
                    ruta.add(ruta);
                    break;
                case 5: 
                    if (currentParada != null) {
                        RegistroHorarios horario = new RegistroHorarios(Integer.parseInt(data[0]), LocalTime.parse(data[3]), LocalTime.parse(data[4]));
                        currentParada.setHorario(horario);
                    }
                    break;
                default:
                    break;
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error no se encuentran los Datos" + e.getMessage());
     }
   }
}
