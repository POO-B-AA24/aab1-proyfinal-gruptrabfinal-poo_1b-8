package Controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class GestionRutas {
    private List<RegistroParadas> paradas;
    private List<OptimizacionRutas> rutas;
    private List<InterfazUsuario> usuarios;

    public GestionRutas() {
        paradas = new ArrayList<>();
        rutas = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void regParada(RegistroParadas parada) {
        paradas.add(parada);
    }

    public void regRuta(OptimizacionRutas ruta) {
        rutas.add(ruta);
    }

    public void regUsuario(InterfazUsuario usuario) {
        usuarios.add(usuario);
    }

    public List<RegistroParadas> consultaParada() {
        return paradas;
    }

    public List<OptimizacionRutas> consultaRuta() {
        return rutas;
    }

    public List<InterfazUsuario> consultaUsuarios() {
        return usuarios;
    }

    public void guardarDatos(String nombreArchivo) {
        try (Formatter formatter = new Formatter(nombreArchivo)) {
            for (RegistroParadas parada : paradas) {
                parada.guardar(formatter);
            }
            for (OptimizacionRutas ruta : rutas) {
                ruta.guardar(formatter);
            }
            for (InterfazUsuario usuario : usuarios) {
                usuario.guardar(formatter);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error No se Guardaron los Datos " + e.getMessage());
        }
    }

    public void cargarDatos(String nombreArchivo) {
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] data = linea.split(",");
                switch (data.length) {
                    case 3:
                        RegistroParadas parada = new RegistroParadas(data[0], Integer.parseInt(data[1]), data[2]);
                        paradas.add(parada);
                        break;
                    case 4:
                        InterfazUsuario usuario = new InterfazUsuario(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                        usuarios.add(usuario);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error No se encuentran los Datos: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Gestion{" + 
                "paradas=" + paradas + "\n" +
                ", rutas=" + rutas + "\n" +
                ", usuarios=" + usuarios + 
                '}';
    }
}
