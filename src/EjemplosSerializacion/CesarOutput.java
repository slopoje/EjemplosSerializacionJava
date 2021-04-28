package EjemplosSerializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import cesar.TextoEncriptado;

/**
 * Ejemplo de serialización de objetos (flujo de salida). Se serializa un objeto de la clase
 * TextoEncriptado en un fichero llamado cesar.dat.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class CesarOutput {
    
    public static void main(String[] args) {
        
        TextoEncriptado texto = new TextoEncriptado("Beati hispani quibus vivere est bibere", 1);
               
        try (FileOutputStream fos = new FileOutputStream("cesar.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            
            oos.writeObject(texto);
            System.out.println("Texto encriptado y guardado correctamente.");
            
        } catch (FileNotFoundException ex) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        }
    }
}
