package domain;

public class Persona {

    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;


    public Persona() {

    }

    public Persona(int idPersona) {
                /*Necesidad de crear objetos solo con el idPersona, ya que cuando eliminamos un objeto de tipo Persona basta
                con proporcionar el idPersona para poder eliminar un registro por completo.*/
        this.idPersona = idPersona;
    }

    /*
    De la misma forma como se trabaja la sentencia de INSERT el campo de idPersona es PK y ademas es auto incrementable, por tanto cuando vamos a
    ingresar un registro en la base de datos en la tabla de Persona, podemos omitir el valor de idPersona, esto solo cuando vamos a insertar.

    De forma que crearemos un constructor que nos permita crear un objeto, sin la necesidad de poder el idPersona, ya que como dije antes, este es
    auto incrementable.

    Para ello crearemos un metodo con todos los parametros menos idPersona.
     */

    public Persona(String nombre, String apellido, String email, String telefono) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;

    }

    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) { // TODOS los atributos

        /*
        Este constructor es en caso de querer modificar un registro.
         */
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
