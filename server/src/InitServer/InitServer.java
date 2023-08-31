package InitServer;

import Server.Server;

public class InitServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server();

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

        server.setPort();
        server.start();
    }
}