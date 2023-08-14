package Server;

import Controller.PessoaController;
import Controller.SetorController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server implements ServerObserver{

    private PessoaController pessoaController;
    private SetorController setorController;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Server() throws SocketException{
        this.pessoaController = new PessoaController(this);
        this.setorController = new SetorController(this);
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(1010);
            server.setReuseAddress(true);
            while (true) {
                System.out.println("Aguardando conexão...");
                Socket conn = server.accept();
                System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
                inputStream = conn.getInputStream();
                //Validar implementação da mensagem do cliente.
                //String mensagem = inputStream.toString();
                operacao(utilString("INSERT;123;Felipe;Rua 23 de Abril"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void operacao(String[] arrayStrig) {

    }

    private String[] utilString(String mensagem){
        String[] arrayString = mensagem.split(";");
        arrayString[0].toUpperCase();
        return arrayString;
    }

    @Override
    public void retornaMensagemCliente(String mensagem) {

    }
}
