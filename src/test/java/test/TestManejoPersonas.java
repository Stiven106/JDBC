package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        // Insertando un nuevo objeto de tipo Persona
        /* Persona personaNueva = new Persona("Carlos", "Esparza", "carlosEzp@mail.com",
                "3045809238"); // Constructor sin idPersona, ya que como es un insert, este parametro se ingresa en automatico.
        personaDao.insertar(personaNueva);*/ // No hay necesidad de crear un nuevo objeto de personaDao, si no que podemos reutilizar el que creamos al principio de esta clase.

        // Modificar un objeto de persona existente, o sea, un registro.
        /*Persona personaModificar = new Persona(2, "Oscar", "Perez", "Oscar2020@mail.com",
                "3203101020"); // Todos los argumentos, ya que tenemos que indicar el id_persona que queremos modificar.
        personaDao.actualizar(personaModificar);*/

        // Eliminar un registro
        Persona personaEliminar = new Persona(1);
        personaDao.eliminar(personaEliminar);


        // Listado Persona: Recuperaremos la informacion de el metodo seleccionar():

        List<Persona> personas = personaDao.seleccionar();

        // Para imprimir recuerda que es con un forEach o funcion lambda
        for (Persona persona: personas) {
            System.out.println("persona = " + persona);
        }

        /*
        Funcion lambda:
        personas.stream().map(persona -> "persona = " + persona).forEach(System.out::println);
         */

    }

}
