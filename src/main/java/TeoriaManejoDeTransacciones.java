public class TeoriaManejoDeTransacciones {
    /*

    Una transaccion es un conjunto de instrucciones agrupadas en un bloque de ejecucion.

    Uso de metodos en una transaccion:
    * autocommit. (Valores true o false).
    * commit. Guarda los cambios en la BD del bloque de ejecucion.
    * rollback. Revierte los cambios realizados por el bloque de ejecucion.

    Por defaul, la propiedad autocommit tiene el valor de true.

    Si cerramos la conexion de JDBC se hace un commit, incluso si se deshabilito la propiedad autocommit.
    Por tanto deberemos de tener cuidado con los cambios que hagamos en la BD.



     */
}
