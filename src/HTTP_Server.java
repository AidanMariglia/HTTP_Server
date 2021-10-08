import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTP_Server {
    public static void main(String[] args) throws Exception {

        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connections on port 8080....");
        while (true) {
            final Socket client = server.accept();
        }
    }
}
