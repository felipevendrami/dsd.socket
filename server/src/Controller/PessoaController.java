package Controller;

import Model.Pessoa;
import Repository.PessoaRepository;
import Server.ServerObserver;

import java.util.List;

public class PessoaController implements OperacoesController {

    private ServerObserver server;
    private PessoaRepository pessoaRepository = new PessoaRepository();

    public PessoaController(ServerObserver server) {
        this.server = server;
    }

    @Override
    public void insert(String[] arrayDados) {
        Pessoa pessoa = new Pessoa(arrayDados[1].trim());
        pessoa.setNome(arrayDados[2].trim());
        pessoa.setEndereco(arrayDados[3].trim());
        pessoaRepository.insert(pessoa);
    }

    @Override
    public void update(String[] arrayDados) {
        try {
            Pessoa pessoa = new Pessoa(arrayDados[1].trim());
            pessoa.setNome(arrayDados[2].trim());
            pessoa.setEndereco(arrayDados[3].trim());
            pessoaRepository.update(pessoa);
            server.retornaMensagemCliente("Pessoa atualizada com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }

    }

    @Override
    public void delete(String[] arrayDados) {
        try {
            pessoaRepository.delete(arrayDados[1]);
            server.retornaMensagemCliente("Pessoa removida com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    @Override
    public void get(String[] arrayDados) {
        try {
            Pessoa pessoa = pessoaRepository.get(arrayDados[1]);
            server.retornaMensagemCliente(pessoa.toString());
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    public void getAll() {
        List<Pessoa> pessoas = pessoaRepository.getAll();
        if (pessoas.size() > 0) {
            server.retornaMensagemCliente(String.valueOf(pessoas.size()));
            pessoas.forEach(pessoa -> server.retornaMensagemCliente(pessoa.toString()));
        } else {
            server.retornaMensagemCliente("0");
        }
    }

    public Pessoa getPessoa(String cpf){
        try{
            return pessoaRepository.get(cpf);
        } catch (Exception e){
            server.retornaMensagemCliente(e.getMessage());
        }
        return null;
    }
}
