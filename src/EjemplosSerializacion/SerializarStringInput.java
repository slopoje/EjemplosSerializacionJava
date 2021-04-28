package EjemplosSerializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Ejemplo de serialización de objetos String (flujo de entrada). Se van a leer
 * varios objetos String de un fichero utilizando un flujo.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarStringInput {

    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String linea;

        try {
            System.out.print("Abriendo fichero...");
            fis = new FileInputStream("Quijote.dat");
            System.out.println("OK");

            System.out.print("Creando flujo de entrada sobre el fichero...");
            ois = new ObjectInputStream(fis);
            System.out.println("OK");

            System.out.println("Imprimiendo las líneas del fichero...");
            while (fis.available() > 0) {
                linea = (String) ois.readObject();
                System.out.println("  -->" + linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("ERROR: No se puede acceder al fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: No se encuentra la clase.");
        } finally {
            System.out.print("Cerrando el fichero...");
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
                System.out.println("OK");
            } catch (IOException e) {
                System.out.println("ERROR: No se ha podido cerrar el fichero.");
            }
        }
    }
}
