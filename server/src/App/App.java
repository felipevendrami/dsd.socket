package App;

import Server.Server;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
    	
        Server server = new Server();

        // POPULAR LISTAS
        server.popularListas("insert;111;Mario Costa;Av Araujo");
        server.popularListas("insert;222;Paulo Sergio;Rua Tiradentes");
        server.popularListas("insert;333;Ana Paula;Rua Cuba");
        server.popularListas("insert;123;Marcos Ruan;Rua 25 de Julho");
        server.popularListas("insert;456;Jose Silva;Av Oliveira");
        server.popularListas("insert_setor;Desenvolvimento;Subdevs");
        server.popularListas("insert_setor;Suporte;Subdevs");
        server.popularListas("insert_setor;Comercial;SS Marketing");
        server.popularListas("add;2;111");
        server.popularListas("add;2;123");
        server.popularListas("add;1;456");

        server.start(); //DESCONMENTAR PARA LIGAR O SERVIDOR

        // PARA TESTES, DELETAR ANTES DA ENTREGA
//        Scanner scan = new Scanner(System.in);
//        while (true){
//            try{
//                System.out.print("Digite a operação: ");
//                String entrada = scan.nextLine();
//                server.popularListas(entrada);
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//        }

    }
}