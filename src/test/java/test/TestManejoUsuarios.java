package test;

import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;

import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {

        /*
        Para insertar y actualizar se utilizan todos menos el id
        Para borrar se utiliza solo el id
        Para modificar se utilizan todos

        Debemos de crear un objeto de tipo clase entidad, utilizando el constructor correspondiente, y luego agregarlo a la lista de tipo DAO.

        Pasos para realizar el CRUD:

        1. Crear un objeto de tipo DAO, que sera con el que vamos a trabajar.
        2. Crear un objeto de tipo clase entidad, que contiene los metodos constructores.
        3. Dentro del constructor de la clase entidad, pondremos los parametros correspondientes al metodo, en el caso de insert en este
        ejemplo serian solamente 2.
        4. Ultimo paso, agregamos el objeto tipo clase entidad, al objeto DAO.

         */

        UsuarioDAO usuarioDao = new UsuarioDAO();

                    // Insertar

        /*Usuario usuarioNuevo = new Usuario("Eliminar2010","123456222");
        usuarioDao.insert(usuarioNuevo);*/

                    // Actualizar
        /*Usuario usuarioUpdate = new Usuario(2L, "OscarL4231", "654321");
        usuarioDao.update(usuarioUpdate);*/

                    //Eliminar
        /*Usuario usuarioEliminar = new Usuario(3L);
        usuarioDao.delete(usuarioEliminar);*/



        //  Listado Persona: Recuperaremos la informacion de el metodo seleccionar():

        List<Usuario> usuarios = usuarioDao.select();

        // Para imprimir recuerda que es con un forEach o funcion lambda

            //Funcion lambda:
        usuarios.stream().map(usuario -> "persona = " + usuario).forEach(System.out::println);

    }

}
