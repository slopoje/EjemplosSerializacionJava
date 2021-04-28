package EjemplosSerializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * Ejemplo de serialización de array de objetos (flujo de entrada). Se lee un
 * array de objetos Persona de del fichero y se imprime su contenido.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarArrayDeObjetosInput {

    public static void main(String[] args) {

        Persona[] personas = null;

        System.out.print("Abriendo fichero, abriendo flujo, leyendo array, cerrando fichero...");
        try (FileInputStream fis = new FileInputStream("arrayPersonas.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            personas = (Persona[]) ois.readObject();
            System.out.println("El contenido del array leido del fichero es:");
            System.out.println(Arrays.toString(personas));
            System.out.println("OK");
            
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nERROR: No se encuentra la clase.");
        }
    }
}
