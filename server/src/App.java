import Server.Server;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        //server.start();

        // PARA TESTES
        Scanner scan = new Scanner(System.in);
        while (true){
            try{
                System.out.print("Digite a operação: ");
                String entrada = scan.nextLine();
                server.operacaoTeste(entrada);
            } catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
