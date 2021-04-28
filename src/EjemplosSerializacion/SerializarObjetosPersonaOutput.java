package EjemplosSerializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Ejemplo de serialización de objetos de una clase que implementa la interface
 * Serializable (flujo de salida). Se van a escribir (serializar) varios objetos
 * de la clase Persona a un fichero.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarObjetosPersonaOutput {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        Persona persona;

        try {
            System.out.print("Creando fichero, abriendo flujo, escribiendo objetos, cerrando fichero...");
            fos = new FileOutputStream("personas.dat");
            oos = new ObjectOutputStream(fos);

            persona = new Persona("Marta", 27);
            oos.writeObject(persona);
            persona = new Persona("Carlos", 31);
            oos.writeObject(persona);
            persona = new Persona("Ana", 24);
            oos.writeObject(persona);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("ERROR: No se puede acceder al fichero.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("ERROR: No se ha podido cerrar el fichero.");
            }
            System.out.println("OK");
        }

    }
}
