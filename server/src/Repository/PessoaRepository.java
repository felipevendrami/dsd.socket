package Repository;

import Model.Pessoa;

import java.util.HashMap;
import java.util.List;

public class PessoaRepository {

    private HashMap<String, Pessoa> pessoas = new HashMap<>();

    public void addPessoa(Pessoa p){
        pessoas.put(p.getCpf(), p);
    }

    public void removePessoa(String cpf){
        pessoas.remove(cpf);
    }

    public Pessoa getPessoa(String cpf){
        return pessoas.get(cpf);
    }

    public List<Pessoa> getAllPessoas(){
        return (List) pessoas.values();
    }
}
