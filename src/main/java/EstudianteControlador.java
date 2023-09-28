import modelo.Carrera;
import modelo.Estudiante;
import modelo.Package.DBConnector;
import modelo.Package.DBGenerator;
import org.jooq.DSLContext;

public class EstudianteControlador {
    public static boolean registrarEstudiante(String nombre, String rut, String matricula, String codigoCarrera) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        if(!EstudianteDAO.validarExistenciaEstudiante(query,"rut",rut)){
            Carrera carrera =CarreraDAO.buscarCarrera(query,codigoCarrera);
            Estudiante estudiante= new Estudiante(rut,nombre,matricula,carrera);
            EstudianteDAO.agregarEstudiante(query,estudiante);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }

    public static <DSLContext> String[][] mostrarEstudiantesPorCarrera(String codigo) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        String[][] datosEstudiantes= EstudianteDAO.obtenerEstudiantesCursoCodigo(query,codigo);
        DBConnector.closeConnection();
        return datosEstudiantes;
    }

    public static <DSLContext> String[][] mostrarEstudiantePorNombre(String codigo, String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        String[][] datosEstudiantes = EstudianteDAO.obtenerEstudiantesCursoNombre(query,nombre,codigo);
        DBConnector.closeConnection();
        return datosEstudiantes;
    }

}