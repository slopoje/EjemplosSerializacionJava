package EjemplosSerializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Ejemplo de serialización de objetos de una clase que implementa la interface
 * Serializable (flujo de entrada). Se van a leer los objetos de clase Persona
 * que hay serializados en el fichero "personas.dat".
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarObjetosPersonaInput {

    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Persona persona;

        try {
            System.out.println("Abriendo fichero, abriendo flujo, leyendo objetos...");
            fis = new FileInputStream("personas.dat");
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                persona = (Persona) ois.readObject();
                System.out.println("  -->" + persona.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nERROR: No se encuentra la clase.");
        } finally {
            try {
                System.out.print("Cerrando fichero...");
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("\nERROR: No se ha podido cerrar el fichero.");
            }
            System.out.println("OK");
        }

    }
}
