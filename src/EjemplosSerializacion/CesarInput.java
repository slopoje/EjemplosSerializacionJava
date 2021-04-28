package EjemplosSerializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import cesar.TextoEncriptado;

/**
 * Ejemplo de serialización de objetos (flujo de entrada). Se lee un objeto de
 * la clase TextoEncriptado de un fichero llamado cesar.dat.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class CesarInput {

    public static void main(String[] args) {

        TextoEncriptado texto;

        try (FileInputStream fis = new FileInputStream("cesar.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            texto = (TextoEncriptado) ois.readObject();
            System.out.println("Texto leído y desencriptado: " + texto.descifradoCesar());

        } catch (FileNotFoundException ex) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nERROR: Clase no encontrada.");
        }
    }
}
