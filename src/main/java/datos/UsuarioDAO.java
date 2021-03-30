package datos;

import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario ";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario =?, password = ? WHERE id_usuario = ?" ;
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Long idUsuario = rs.getLong("id_usuario");
                String usser = rs.getString("usuario");
                String password = rs.getString("password");

                usuario = new Usuario(idUsuario, usser, password); // Estamos convirtiendo informacion de la BD, a objetos Java.

                usuarios.add(usuario); // Se agrega a la lista
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
        return usuarios;
    }

    public int insert(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2,usuario.getPass());
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

    public int update(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2,usuario.getPass());
            stmt.setLong(3,usuario.getIdUsuario());
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

    public int delete(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setLong(1,usuario.getIdUsuario());
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

}
