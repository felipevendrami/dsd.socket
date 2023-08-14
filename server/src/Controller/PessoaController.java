package Controller;

import Model.Pessoa;
import Repository.PessoaRepository;
import Server.ServerObserver;

import java.util.List;

public class PessoaController implements Operacoes{

    final String OP_LIST = "LIST";
    private ServerObserver server;
    private PessoaRepository pessoaRepository = new PessoaRepository();

    public PessoaController(ServerObserver server) {
        this.server = server;
    }

    @Override
    public void definirOperacao(String[] arrayDados) {
        switch (arrayDados[0]){
            case OP_INSERT -> insert(arrayDados);
            case OP_UPDATE -> update(arrayDados);
            case OP_DELETE -> update(arrayDados);
            case OP_GET -> get(arrayDados);
            case OP_LIST -> list();
            default -> server.retornaMensagemCliente("Operação não encontrada.");
        }
    }

    @Override
    public void insert(String[] arrayDados) {
        Pessoa pessoa = new Pessoa(arrayDados[1].trim());
        pessoa.setNome(arrayDados[2].trim());
        pessoa.setEndereco(arrayDados[3].trim());
        pessoaRepository.addPessoa(pessoa);
    }

    @Override
    public void update(String[] arrayDados){
        try{
            Pessoa pessoa = new Pessoa(arrayDados[1].trim());
            pessoa.setNome(arrayDados[2].trim());
            pessoa.setEndereco(arrayDados[3].trim());
            pessoaRepository.updatePessoa(pessoa);
        } catch (Exception e){
            server.retornaMensagemCliente(e.getMessage());
        }

    }

    @Override
    public void delete(String[] arrayDados) {
        try {
            pessoaRepository.removePessoa(arrayDados[1]);
        } catch (Exception e){
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    @Override
    public void get(String[] arrayDados) {
        try{
            Pessoa pessoa = pessoaRepository.getPessoa(arrayDados[1]);
            server.retornaMensagemCliente(pessoa.toString());
        } catch (Exception e){
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    public void list(){
        String retorno = "";
        List<Pessoa> pessoas = pessoaRepository.getAllPessoas();
        if(pessoas.size() > 0){
            retorno += pessoas.size() + "\n";
            for(Pessoa p : pessoas){
                retorno += p.toString() + "\n";
            }
        } else {
            retorno = "0";
        }
        server.retornaMensagemCliente(retorno);
    }
}
