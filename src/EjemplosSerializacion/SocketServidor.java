package EjemplosSerializacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ejemplo de serialización de objetos vía socket (servidor). Se crea un socket
 * y se "escucha" el puerto TCP esperando una conexión del cliente, cuando esta
 * se produce se envían serializados tres objetos de tipo persona.
 *
 * @author IES Aguadulce - Módulo Programación
 * @version 26/03/2021
 */
public class SocketServidor {

    public static void main(String[] args) {

        Socket socket = null;
        ObjectOutputStream oos = null;
        Persona persona;

        try {
            System.out.print("Creando el socket en el servidor...");
            ServerSocket server = new ServerSocket(9999);
            System.out.println("OK");

            System.out.print("Esperando conexión del cliente...");
            socket = server.accept();
            System.out.println("OK");

            System.out.print("Creando flujo de salida...");
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("OK");

            System.out.print("Enviando objetos serializados...");
            persona = new Persona("Marta", 27);
            oos.writeObject(persona);
            persona = new Persona("Carlos", 31);
            oos.writeObject(persona);
            persona = new Persona("Ana", 24);
            oos.writeObject(persona);
            System.out.println("OK");

            System.out.print("Cerrando flujo y socket...");
            oos.close();
            server.close();
            System.out.println("OK");

        } catch (IOException e) {
            System.out.println("ERROR: No se puede crear el socket.");
        }

    }
}
