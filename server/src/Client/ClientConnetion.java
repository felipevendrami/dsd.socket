package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnetion {

    private Socket connection;
    private PrintWriter output;
    private BufferedReader input;

    public void getConnection(String serverIp, int serverPort) throws IOException {
        try {
            this.connection = new Socket (serverIp.trim(), serverPort);
            this.output = new PrintWriter(connection.getOutputStream(), true);
            this.input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendOutputMsg(String msg) {
        this.output.println(msg);
    }

    public void getInputMsg() throws IOException {
        String msg;
        while ((msg = this.input.readLine()) != null){
            System.out.println(msg);
        }
    }

    public void closeConnection() throws IOException {
        if (this.connection != null){
            this.connection.close();
        }
    }
}