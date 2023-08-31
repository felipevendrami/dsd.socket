package Repository;

import Model.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PessoaRepository {

    private HashMap<String, Pessoa> pessoas = new HashMap<>();

    public void insert(Pessoa pessoa) throws Exception {
        try{
            pessoas.put(pessoa.getCpf(), pessoa);
        } catch (Exception e){
            throw new Exception("Houve um problema na insercao.");
        }
    }

    public void update(Pessoa pessoa) throws Exception {
        if (pessoas.containsKey(pessoa.getCpf())) {
            pessoas.replace(pessoa.getCpf(), pessoa);
        } else {
            throw new Exception("Pessoa nao encontrada.");
        }
    }

    public void delete(String cpf) throws Exception {
        if (!pessoas.isEmpty()) {
            if (pessoas.containsKey(cpf)) {
                Pessoa pessoa = get(cpf);
                if (pessoa.getSetor() != null){
                    pessoa.getSetor().removeIntegrante(pessoa);
                }
                pessoas.remove(cpf);
            } else
                throw new Exception("Pessoa nao encontrada.");
        } else {
            throw new Exception("Sem pessoas cadastradas.");
        }
    }

    public Pessoa get(String cpf) throws Exception {
        if (!pessoas.isEmpty()) {
            if (pessoas.containsKey(cpf)) {
                return pessoas.get(cpf);
            } else {
                throw new Exception("Pessoa nao encontrada.");
            }
        } else {
            throw new Exception("Sem pessoas cadastradas.");
        }
    }

    public List getAll() {
        List<Pessoa> pessoasArrayList = new ArrayList<>(pessoas.values());
        return pessoasArrayList;
    }
}
