package Client;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        menuInicial();
    }

    private static void menuInicial() throws IOException {
        try{
            Scanner s = new Scanner(System.in);
            s.useDelimiter("\n");

            System.out.println("Por favor, informe o IP do servidor");
            String serverIp = s.next();
            System.out.println("Por favor, informe a porta do servidor");
            int serverPort = Integer.parseInt(s.next().trim());

            executaCliente(serverIp, serverPort);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void executaCliente(String serverIp, int serverPort) throws IOException {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Escolha uma opcao para continuar: \n"
                + "1 - Pessoa \n"
                + "2 - Setor \n"
                + "3 - Voltar"
        );

        int option = Integer.parseInt(s.next().trim());

        switch (option) {
            case 1:
                editPessoa(serverIp, serverPort);
                break;
            case 2:
                editSetor(serverIp, serverPort);
                break;
            case 4:
                menuInicial();
                break;
            default:
                System.out.println("Por favor, informe uma opcao valida!");
                executaCliente(serverIp, serverPort);

            s.close();
        }
    }

    private static void editPessoa(String serverIp, int serverPort) throws IOException {

        ClientConnetion conn = new ClientConnetion();

        do {
            Scanner s = new Scanner(System.in);
            s.useDelimiter("\n");

            String cpf;
            String nome;
            String endereco;
            String comando;

            System.out.println("====================================");
            System.out.println("Manutencao de Pessoa");
            System.out.println("Selecione uma opcao para continuar: \n"
                    + "1 - Inserir \n"
                    + "2 - Atualizar \n"
                    + "3 - Obter \n"
                    + "4 - Remover \n"
                    + "5 - Listar Pessoas \n"
                    + "6 - Voltar \n"
            );

            int opcao = Integer.parseInt(s.next().trim());

            switch (opcao) {
                case 1:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Inserir Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();
                    System.out.println("Informe o nome");
                    nome = s.next().trim();
                    System.out.println("Informe o endereco");
                    endereco = s.next().trim();

                    comando = "INSERT;"
                            + cpf + ";"
                            + nome + ";"
                            + endereco;
                    conn.sendOutputMsg(comando);
                    conn.closeConnection();
                    s.close();
                    break;

                case 2:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Atualizar Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();
                    System.out.println("Informe o nome");
                    nome = s.next().trim();
                    System.out.println("Informe o endereco");
                    endereco = s.next().trim();

                    comando = "UPDATE;"
                            + cpf + ";"
                            + nome + ";"
                            + endereco;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 3:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Obter Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();

                    comando = "GET;"
                            + cpf;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 4:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Remover Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();

                    comando = "DELETE;"
                            + cpf;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 5:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Listar Pessoas");
                    comando = "LIST";
                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 6:
                    s.close();
                    executaCliente(serverIp, serverPort);
                    return;

                default:
                    System.out.println("Por favor, informe uma opcao valida!");
                    s.close();
                    editPessoa(serverIp, serverPort);
                    return;
            }
        } while (true);
    }

    private static void editSetor(String serverIp, int serverPort) throws IOException {

        ClientConnetion conn = new ClientConnetion();

        do {
            Scanner s = new Scanner(System.in);
            s.useDelimiter("\n");

            String cpf;
            String nome;
            String endereco;
            String nomeSetor;
            String nomeEmpresa;
            int codigoSetor;
            String comando;

            System.out.println("====================================");
            System.out.println("Manutencao de Setor");
            System.out.println("Selecione uma opcao para continuar: \n"
                    + "1 - Inserir \n"
                    + "2 - Atualizar \n"
                    + "3 - Obter \n"
                    + "4 - Remover \n"
                    + "5 - Listar Setores \n"
                    + "6 - Adicionar Pessoa ao Setor \n"
                    + "7 - Remover Pessoa do Setor \n"
                    + "8 - Voltar \n"
            );

            int opcao = Integer.parseInt(s.next().trim());

            switch (opcao) {
                case 1:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Inserir Setor");
                    System.out.println("Informe o nome do Setor");
                    nomeSetor = s.next().trim();
                    System.out.println("Informe o nome da Empresa");
                    nomeEmpresa = s.next().trim();

                    comando = "INSERT_SETOR;"
                            + nomeSetor + ";"
                            + nomeEmpresa;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 2:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Atualizar Setor");
                    System.out.println("Informe o codigo do Setor");
                    codigoSetor = Integer.parseInt(s.next().trim());
                    System.out.println("Informe o nome do Setor");
                    nomeSetor = s.next().trim();
                    System.out.println("Informe o nome da Empresa");
                    nomeEmpresa = s.next().trim();

                    comando = "UPDATE_SETOR;"
                            + codigoSetor + ";"
                            + nomeSetor + ";"
                            + nomeEmpresa;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 3:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Obter Setor");
                    System.out.println("Informe o codigo do Setor");
                    codigoSetor = Integer.parseInt(s.next().trim());

                    comando = "GET_SETOR;"
                            + codigoSetor;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 4:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Remover Setor");
                    System.out.println("Informe o codigo do Setor");
                    codigoSetor = Integer.parseInt(s.next().trim());

                    comando = "DELETE_SETOR;"
                            + codigoSetor;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 5:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Listando Setores");

                    comando = "LIST_SETOR";

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 6:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Adicionar Pessoa ao Setor");
                    System.out.println("Informe o codigo do Setor");
                    codigoSetor = Integer.parseInt(s.next().trim());
                    System.out.println("Informe o CPF da Pessoa");
                    cpf = s.next().trim();

                    comando = "ADD;"
                            + codigoSetor  + ";"
                            + cpf;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 7:
                    conn.getConnection(serverIp, serverPort);

                    System.out.println("====================================");
                    System.out.println("Remover Pessoa do Setor");
                    System.out.println("Informe o codigo do Setor");
                    codigoSetor = Integer.parseInt(s.next().trim());
                    System.out.println("Informe o CPF da Pessoa");
                    cpf = s.next().trim();

                    comando = "REMOVE;"
                            + codigoSetor  + ";"
                            + cpf;

                    conn.sendOutputMsg(comando);
                    conn.getInputMsg();
                    conn.closeConnection();
                    s.close();
                    break;

                case 8:
                    s.close();
                    executaCliente(serverIp, serverPort);
                    return;

                default:
                    System.out.println("Por favor, informe uma opcao valida!");
                    s.close();
                    editSetor(serverIp, serverPort);
                    return;
            }
        } while (true);
    }
}