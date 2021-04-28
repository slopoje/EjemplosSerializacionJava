package EjemplosSerializacion;

import java.io.Serializable;

/**
 * Clase que permite su serialización. Clase simple para practicar la
 * serialización de objetos, implementa la interface Serializable y
 * añade el atributo serialVersionUID.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private static final long serialVersionUID = 1L;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.edad;
    }
}
