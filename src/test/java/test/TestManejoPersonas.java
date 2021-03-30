package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {

        // Connection debe estar declarado fuera del try catch, para utilizar la conexion.rollback en el catch
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            // Revisar si esta en manejo autocommit
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                /*
                Con el autocommit al terminar de ejecutar una sentencia, en automatico se guardan los cambios. En este caso lo que queremos es
                que apenas cuando se haga commit de toda la transaccion se guarden los cambios. Por eso lo dejamos en false.
                 */
            }
            PersonaDAO personaDao = new PersonaDAO(conexion);

            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(3);
            cambioPersona.setNombre("Kiel carlos");
            cambioPersona.setApellido("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setTelefono("323121234");
            personaDao.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            // Agregamos un fallo en el siguiente insert aproposito, para probar la funcion del rollback. Excede varchar(45)
            /*nuevaPersona.setApellido("Ramirezzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");*/
            // Se valido el funcionamiento del rollback, ahora con un apellido valido:
            nuevaPersona.setApellido("Ramirez");
            personaDao.insertar(nuevaPersona);

            // Hacemos el commit para que la transaccion se guarde en la BD
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback"   );
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }

        }


    }

}
