package Server;

import Controller.PessoaController;
import Controller.SetorController;
import Model.Pessoa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server implements ServerObserver {

    private PessoaController pessoaController;
    private SetorController setorController;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public Server() throws SocketException {
        this.pessoaController = new PessoaController(this);
        this.setorController = new SetorController(this);
    }

    public void start() throws IOException {
        try {
            ServerSocket server = new ServerSocket(1010);
            server.setReuseAddress(true);
            Socket conn = null;
            while (true) {
                try {
                    System.out.println("Aguardando nova conexão...");
                    conn = server.accept();
                    System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
                    bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    printWriter = new PrintWriter(conn.getOutputStream(), true);

                    System.out.println("Aguardando interação...");
                    String msgCliente = bufferedReader.readLine();
                    operacao(utilString(msgCliente));
                    System.out.println("Operação finalizada.");
                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu erro no servido.");
            e.printStackTrace();
        }
    }

    private void operacao(String[] arrayString) {
        switch (arrayString[0]) {
            case "INSERT" -> pessoaController.insert(arrayString);
            case "UPDATE" -> pessoaController.update(arrayString);
            case "DELETE" -> pessoaController.delete(arrayString);
            case "GET" -> pessoaController.get(arrayString);
            case "LIST" -> pessoaController.getAll();
            case "INSERT_SETOR" -> setorController.insert(arrayString);
            case "UPDATE_SETOR" -> setorController.update(arrayString);
            case "DELETE_SETOR" -> setorController.delete(arrayString);
            case "GET_SETOR" -> setorController.get(arrayString);
            case "LIST_SETOR" -> setorController.getAll();
            case "ADD" -> {
                Pessoa pessoa = pessoaController.getPessoa(arrayString[2]);
                setorController.add(arrayString[1], pessoa);
            }
            case "REMOVE" -> {
                Pessoa pessoa = pessoaController.getPessoa(arrayString[2]);
                setorController.remove(arrayString[1], pessoa);
            }
            default -> retornaMensagemCliente("Operação não encontrada.");
        }
    }

    private String[] utilString(String mensagem) {
        String[] arrayString = mensagem.split(";");
        arrayString[0] = arrayString[0].toUpperCase();
        return arrayString;
    }

    @Override
    public void retornaMensagemCliente(String mensagem) {
        System.out.println(mensagem);
        printWriter.print(mensagem);
    }
}
