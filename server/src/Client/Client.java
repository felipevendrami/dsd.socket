package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        Socket conn = null;
        System.out.println("Buscando conexão...");

        try {
            conn = new Socket("192.168.0.108", 1010);
            System.out.println("Conexão com o servidor estabelecida.");
            PrintWriter output = new PrintWriter(conn.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while (true) {
//                System.out.println("Aguardando mensagem");
//                String inputMsg = input.readLine();
//                if (inputMsg == null){
//                    System.out.println("Conexão encerrada pelo servidor.");
//                    break;
//                }
//
//                System.out.println("Mensagem recebida: " + inputMsg);

                System.out.println("Digite a mensagem");
                String outputMsg = scan.nextLine();
                if (outputMsg.equalsIgnoreCase("Sair")) {
                    break;
                }

                output.println(outputMsg);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um problema");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
                System.out.println("Conexão encerrada");
            }
        }
    }

    private static void executaCliente() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Escolha uma opção para continuar: \n"
                + "1 - Pessoa \n"
                + "2 - Setor"
        );

        int option = s.nextInt();

        switch (option) {
            case 1:
                editPessoa();
                break;
            case 2:
                editSetor();
                break;
            default:
                System.out.println("Por favor, informe uma opção válida!");
                return;
        }
    }

    private static void editPessoa() {

        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");


        do {
            String cpf;
            String nome;
            String endereco;
            String comando;

            System.out.println("====================================");
            System.out.println("Manutenção de Pessoa");
            System.out.println("Selecione uma opção para continuar: \n"
                    + "1 - Inserir \n"
                    + "2 - Atualizar \n"
                    + "3 - Obter \n"
                    + "4 - Remover \n"
                    + "5 - Listar Pessoas \n"
                    + "6 - Voltar \n"
            );

            int opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("====================================");
                    System.out.println("Inserir Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();
                    System.out.println("Informe o nome");
                    nome = s.next().trim();
                    System.out.println("Informe o endereço");
                    endereco = s.next().trim();

                    comando = "INSERT;"
                            + cpf + ";"
                            + nome + ";"
                            + endereco;

                    //TODO enviar o comando!
                    break;

                case 2:
                    System.out.println("====================================");
                    System.out.println("Atualizar Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();
                    System.out.println("Informe o nome");
                    nome = s.next().trim();
                    System.out.println("Informe o endereço");
                    endereco = s.next().trim();

                    comando = "UPDATE;"
                            + cpf + ";"
                            + nome + ";"
                            + endereco;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 3:
                    System.out.println("====================================");
                    System.out.println("Obter Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();

                    comando = "GET;"
                            + cpf;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 4:
                    System.out.println("====================================");
                    System.out.println("Remover Pessoa");
                    System.out.println("Informe o CPF");
                    cpf = s.next().trim();

                    comando = "DELETE;"
                            + cpf;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 5:
                    System.out.println("====================================");
                    System.out.println("Listar Pessoas");
                    comando = "LIST";
                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 6:
                    //executaCliente();
                    return;

                default:
                    System.out.println("Por favor, informe uma opção válida!");
                    return;
            }
        } while (true);
    }

    private static void editSetor() {

        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        do {
            String cpf;
            String nome;
            String endereco;
            String nomeSetor;
            String nomeEmpresa;
            int codigoSetor;
            int qtdEmpregados;
            String comando;

            System.out.println("====================================");
            System.out.println("Manutenção de Setor");
            System.out.println("Selecione uma opção para continuar: \n"
                    + "1 - Inserir \n"
                    + "2 - Atualizar \n"
                    + "3 - Obter \n"
                    + "4 - Remover \n"
                    + "5 - Listar Setores \n"
                    + "6 - Adicionar Pessoa ao Setor \n"
                    + "7 - Remover Pessoa do Setor \n"
                    + "8 - Voltar \n"
            );

            int opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("====================================");
                    System.out.println("Inserir Setor");
                    System.out.println("Informe o nome do Setor");
                    nomeSetor = s.next().trim();
                    System.out.println("Informe o nome da Empresa");
                    nomeEmpresa = s.next().trim();

                    comando = "INSERT_SETOR;"
                            + nomeSetor + ";"
                            + nomeEmpresa;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 2:
                    System.out.println("====================================");
                    System.out.println("Atualizar Setor");
                    System.out.println("Informe o código do Setor");
                    codigoSetor = s.nextInt();
                    System.out.println("Informe o nome do Setor");
                    nomeSetor = s.next().trim();
                    System.out.println("Informe o nome da Empresa");
                    nomeEmpresa = s.next().trim();

                    comando = "INSERT_SETOR;"
                            + codigoSetor + ";"
                            + nomeSetor + ";"
                            + nomeEmpresa;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 3:
                    System.out.println("====================================");
                    System.out.println("Obter Setor");
                    System.out.println("Informe o código do Setor");
                    codigoSetor = s.nextInt();

                    comando = "GET_SETOR;"
                            + codigoSetor;
                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 4:
                    System.out.println("====================================");
                    System.out.println("Remover Setor");
                    System.out.println("Informe o código do Setor");
                    codigoSetor = s.nextInt();

                    comando = "DELETE_SETOR;"
                            + codigoSetor;
                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 5:
                    System.out.println("====================================");
                    System.out.println("Listando Setores");

                    comando = "LIST_SETOR";

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 6:
                    System.out.println("====================================");
                    System.out.println("Adicionar Pessoa ao Setor");
                    System.out.println("Informe o código do Setor");
                    codigoSetor = s.nextInt();
                    System.out.println("Informe o CPF da Pessoa");
                    cpf = s.next().trim();

                    comando = "ADD;"
                            + codigoSetor  + ";"
                            + cpf;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 7:
                    System.out.println("====================================");
                    System.out.println("Remover Pessoa do Setor");
                    System.out.println("Informe o código do Setor");
                    codigoSetor = s.nextInt();
                    System.out.println("Informe o CPF da Pessoa");
                    cpf = s.next().trim();

                    comando = "REMOVE;"
                            + codigoSetor  + ";"
                            + cpf;

                    //TODO enviar o comando!
                    //TODO receber string!
                    break;

                case 8:
                    //executaCliente();
                    return;

                default:
                    System.out.println("Por favor, informe uma opção válida!");
                    return;
            }
        } while (true);

    }
}