import modelo.Carrera;
import modelo.Package.DBConnector;
import modelo.Package.DBGenerator;
import org.jooq.DSLContext;

public class CarreraControlador {
    public static boolean añadirCarrera(String nombreCarrera, String codigoCarrera, int cantSemestres) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        if(!CarreraDAO.validarExistenciaCarrera(query,"codigo",codigoCarrera)){
            Carrera carrera = new Carrera(nombreCarrera,codigoCarrera,cantSemestres);
            CarreraDAO.agregarCarrera(query,carrera);
            DBConnector.closeConnection();
            return true;
        }
        else{
            return false;
        }
    }
    public static Object[] getCodigoCarreras() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Universidad");
        Object[] carreras = CarreraDAO.getCodigoCarreras(query);
        DBConnector.closeConnection();
        return carreras;
    }
}