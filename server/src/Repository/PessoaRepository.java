package Repository;

import Model.Pessoa;

import java.util.HashMap;
import java.util.List;

public class PessoaRepository {

    private HashMap<String, Pessoa> pessoas = new HashMap<>();

    public void addPessoa(Pessoa p) {
        pessoas.put(p.getCpf(), p);
    }

    public void updatePessoa(Pessoa p) throws Exception{
        try {
            Pessoa pessoa = getPessoa(p.getCpf());
            pessoa.setNome(p.getNome());
            pessoa.setEndereco(p.getEndereco());
            pessoas.put(pessoa.getCpf(), pessoa);
        } catch (Exception e){
            throw new Exception("Pessoa não encontrada.");
        }
    }

    public void removePessoa(String cpf) throws Exception{
        if(!pessoas.isEmpty()){
            try{
                pessoas.remove(cpf);
            } catch (Exception e){
                throw new Exception("Pessoa não encontada.");
            }
        } else {
            throw new Exception("Sem pessoas cadastradas.");
        }
    }

    public Pessoa getPessoa(String cpf) throws Exception{
        try {
            return pessoas.get(cpf);
        } catch (Exception e){
            throw new Exception("Pessoa não encontrada.");
        }
    }

    public List getAllPessoas() {
        return (List) pessoas.values();
    }
}
