package EjemplosSerializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Ejemplo de serialización de objetos String (flujo de salida).
 * Se van a escribir en un fichero varios objetos de tipo String utilizando un flujo.
 * 
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarStringOutput {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String linea;

        try {
            System.out.print("Creando fichero...");
            fos = new FileOutputStream("Quijote.dat");
            System.out.println("OK");
            
            System.out.print("Creando flujo sobre el fichero...");
            oos = new ObjectOutputStream(fos);
            System.out.println("OK");

            System.out.print("Escribiendo líneas en el flujo...");
            linea = "En un lugar de la mancha";
            oos.writeObject(linea);
            linea = "De cuyo nombre no quiero acordarme";
            oos.writeObject(linea);
            linea = "No ha mucho que vívia un hidalgo";
            oos.writeObject(linea);
            System.out.println("OK");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("ERROR: No se puede acceder al fichero.");
        } finally {
            System.out.print("Cerrando el fichero...");
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
                System.out.println("OK");
            } catch (IOException e) {
                System.out.println("ERROR: No se ha podido cerrar el fichero.");
            }
        }

    }
}
