package EjemplosSerializacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Ejemplo de serialización de objetos vía socket (cliente). Se crea un socket
 * y se conecta por el puerto TCP a la dirección local, cuando esta
 * se establece se reciben serializados tres objetos de tipo persona.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SocketCliente {

    public static void main(String[] args) {

        Socket socket = null;
        ObjectInputStream ois = null;
        Persona persona;

        try {
            System.out.print("Creando un socket de conexión con el servidor...");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("OK");

            System.out.print("Creando flujo de entrada...");
            ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("OK");

            System.out.println("Recibiendo objetos serializados...");
            persona = (Persona) ois.readObject();
            System.out.println("  -->"+persona.toString());
            persona = (Persona) ois.readObject();
            System.out.println("  -->"+persona.toString());
            persona = (Persona) ois.readObject();
            System.out.println("  -->"+persona.toString());
            System.out.println("OK");
            
            System.out.print("Cerrando flujo y socket...");
            ois.close();
            socket.close();
            System.out.println("OK");

        } catch (IOException e) {
            System.out.println("ERROR: No se puede crear el socket.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: Clase no encontrada.");
        }

    }
}
