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
import java.util.Scanner;

public class Server implements ServerObserver {

    private PessoaController pessoaController;
    private SetorController setorController;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private int serverPort = 0;

    public Server() {
        this.pessoaController = new PessoaController(this);
        this.setorController = new SetorController(this);
    }

    public void setPort() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");
        System.out.println("Por favor, informe a porta para inicializar o servidor");
        serverPort = Integer.parseInt(s.next().trim());
    }

    public void start() throws IOException {
        try {

            ServerSocket server = new ServerSocket(serverPort);
            server.setReuseAddress(true);
            Socket conn = null;
            while (true) {
                try {
                    System.out.println("Aguardando nova conexao...");
                    conn = server.accept();
                    System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
                    bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    printWriter = new PrintWriter(conn.getOutputStream(), true);

                    System.out.println("Aguardando interacao...");
                    String msgCliente = bufferedReader.readLine();
                    if(msgCliente != null) {
                        operacao(utilString(msgCliente));
                    }
                    System.out.println("Conexao fechada.");
                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                } finally {
                    conn.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Log de erro: \n" + e.getMessage());
            System.out.println("Cliente foi desconectado.");
            start();
        }
    }

    // PARA POPULAR AS LISTAS
    public void popularListas(String msg) throws Exception {
        try {
            operacao(utilString(msg));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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
                try{
                    Pessoa pessoa = pessoaController.getPessoa(arrayString[2]);
                    if(pessoa != null)
                        setorController.add(arrayString[1], pessoa);
                } catch (Exception e){
                    retornaMensagemCliente(e.getMessage());
                }
            }
            case "REMOVE" -> {
                try{
                    Pessoa pessoa = pessoaController.getPessoa(arrayString[2]);
                    if(pessoa != null){
                        setorController.remove(arrayString[1], pessoa);
                    }
                } catch (Exception e){
                    retornaMensagemCliente(e.getMessage());
                }
            }
            default -> retornaMensagemCliente("Operacao nao encontrada.");
        }
    }

    private String[] utilString(String mensagem) {
        String[] arrayString = mensagem.split(";");
        arrayString[0] = arrayString[0].toUpperCase();
        return arrayString;
    }

    @Override
    public void retornaMensagemCliente(String mensagem) {
        if (this.printWriter != null){
            System.out.println(mensagem);
            printWriter.println(mensagem);
        }
    }
}
