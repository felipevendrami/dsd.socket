package Repository;

import Model.Pessoa;

import java.util.HashMap;
import java.util.List;

public class PessoaRepository {

    private HashMap<String, Pessoa> pessoas = new HashMap<>();

    public void insert(Pessoa pessoa) {
        pessoas.put(pessoa.getCpf(), pessoa);
    }

    public void update(Pessoa pessoa) throws Exception {
        if (pessoas.containsKey(pessoa.getCpf())) {
            pessoas.replace(pessoa.getCpf(), pessoa);
        } else {
            throw new Exception("Pessoa não encontrada.");
        }
    }

    public void delete(String cpf) throws Exception {
        if (!pessoas.isEmpty()) {
            if (pessoas.containsKey(cpf)) {
                pessoas.remove(cpf);
            } else
                throw new Exception("Pessoa não encontrada.");
        } else {
            throw new Exception("Sem pessoas cadastradas.");
        }
    }

    public Pessoa get(String cpf) throws Exception {
        if (!pessoas.isEmpty()) {
            if (pessoas.containsKey(cpf)) {
                return pessoas.get(cpf);
            } else {
                throw new Exception("Pessoa não encontrada");
            }
        } else {
            throw new Exception("Sem pessoas cadastradas.");
        }
    }

    public List getAll() {
        return (List) pessoas.values();
    }
}
