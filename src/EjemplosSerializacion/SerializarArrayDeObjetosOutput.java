package EjemplosSerializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Ejemplo de serialización de array de objetos (flujo de salida). Se instancia un array de objetos de la
 * clase Persona y se serializa en un fichero.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SerializarArrayDeObjetosOutput {

    public static void main(String[] args) {

        String nombre;
        int edad;
        Persona[] personas = new Persona[3];

        Scanner teclado = new Scanner(System.in);

        System.out.println("Creando fichero, abriendo flujo, escribiendo array, cerrando fichero...");
        try (FileOutputStream fos = new FileOutputStream("arrayPersonas.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (int i = 0; i < personas.length; ++i) {
                System.out.println("  Persona["+i+"]");
                System.out.print("  Nombre:");
                nombre = teclado.nextLine();
                System.out.print("  Edad:");
                edad = teclado.nextInt();
                teclado.nextLine(); //Hay que vaciar el buffer después de leer un entero
                personas[i] = new Persona(nombre, edad);
            }

            oos.writeObject(personas);
            System.out.println("OK");

        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        }

    }
}
