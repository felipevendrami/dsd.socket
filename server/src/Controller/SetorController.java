package Controller;

import Model.Pessoa;
import Model.Setor;
import Repository.SetorRepository;
import Server.ServerObserver;

import java.util.HashMap;

public class SetorController implements OperacoesController {

    private ServerObserver server;
    private SetorRepository setorRepository = new SetorRepository();


    public SetorController(ServerObserver server) {
        this.server = server;
    }

    public void add(String codigo, Pessoa pessoa) {
        try {
            setorRepository.addIntegrante(Integer.parseInt(codigo), pessoa);
            server.retornaMensagemCliente("Pessoa incluída no setor com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    public void remove(String codigo, Pessoa pessoa) {
        try {
            setorRepository.removeIntegrante(Integer.parseInt(codigo), pessoa);
            server.retornaMensagemCliente("Pessoa removida do setor com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    public void getAll() {
        HashMap<Integer, Setor> setores = setorRepository.getAll();
        if (!setores.isEmpty()) {
            server.retornaMensagemCliente(setores.size() + " setores cadastrados:");
            setores.forEach((codigo, setor) -> {
                server.retornaMensagemCliente(setor.toString(String.valueOf(codigo)));
                setor.getIntegrantes().forEach(pessoa -> server.retornaMensagemCliente(pessoa.toString()));
            });
        } else {
            server.retornaMensagemCliente("0");
        }
    }

    @Override
    public void insert(String[] arrayDados) {
        try {
            Setor setor = new Setor(arrayDados[1].trim());
            setor.setNomeEmpresa(arrayDados[2].trim());
            setorRepository.insert(setor);
            server.retornaMensagemCliente(setor.toString(String.valueOf(setorRepository.getSequence()-1)));
        } catch (Exception e){
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    @Override
    public void update(String[] arrayDados) {
        try {
            Setor setor = new Setor(arrayDados[2].trim());
            setor.setNomeEmpresa(arrayDados[3].trim());
            setorRepository.update(setor, Integer.parseInt(arrayDados[1]));
            server.retornaMensagemCliente("Setor atualizado com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    @Override
    public void delete(String[] arrayDados) {
        try {
            setorRepository.delete(Integer.parseInt(arrayDados[1]));
            server.retornaMensagemCliente("Setor removido com sucesso.");
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }

    @Override
    public void get(String[] arrayDados) {
        try {
            Setor setor = setorRepository.get(Integer.parseInt(arrayDados[1]));
            server.retornaMensagemCliente(setor.toString(arrayDados[1]));
            setor.getIntegrantes().forEach(pessoa -> server.retornaMensagemCliente(pessoa.toString()));
        } catch (Exception e) {
            server.retornaMensagemCliente(e.getMessage());
        }
    }


}
