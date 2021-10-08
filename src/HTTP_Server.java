import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

//currently just prints connection info to console and then sends the date
public class HTTP_Server {
    public static void main(String[] args) throws IOException {

        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connections on port 8080....");

        while(true) {
            try (Socket clientSocket = server.accept()) {
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();

                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
                while(!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            }
        }
    }
}
