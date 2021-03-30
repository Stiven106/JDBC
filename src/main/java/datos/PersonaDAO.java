package datos;

/*
Patron de diseno Data Acces Object: Contiene las operaciones a realizar sobre la clase entidad o domain que es: class Persona
Si tenemos muchas clases entidad, entonces tendremos tambien muchas clases DAO.

Esta clase se encargara de hacer el update, insert delete o select sobre la clase entidad. Para ello lo mejor es que las sentencias las
definamos al inicio de la clase, esto hace parte de las buenas practicas cuando trabajamos con la conexion a la base de datos.

Siempre que tengamos una clase DAO, sera ella con la cual vamos a interactuar, es decir, ejecutaremos los metodos de esta clase en un psvm,
pero no los de la clase Persona.
 */

import domain.Persona;
import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona"; // Otra opcion es con el "*"
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?" ;
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas= new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono); // Estamos convirtiendo informacion de la BD, a objetos Java.

                personas.add(persona); // Se agrega a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;

    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate(); // Actualiza el estado de la base de datos.

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }

    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate(); // Actualiza el estado de la base de datos.

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }

    public int eliminar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate(); // Actualiza el estado de la base de datos. Nos regresa la cantidad de registros modificados.

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }

}
