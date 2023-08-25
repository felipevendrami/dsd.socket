package Repository;

import Model.Pessoa;
import Model.Setor;

import java.util.HashMap;

public class SetorRepository {

    private int sequence = 1;
    private HashMap<Integer, Setor> setores = new HashMap<Integer, Setor>();


    public int getSequence() {
        return this.sequence;
    }

    public void insert(Setor setor) throws Exception {
        try {
            setores.put(sequence++, setor);
        } catch (Exception e) {
            throw new Exception("Erro no cadastro, verifique os dados.");
        }
    }

    public void update(Setor setor, int codigo) throws Exception {
        if (setores.containsKey(codigo)) {
            setor.setIntegrantes(setores.get(codigo).getIntegrantes());
            setor.setQtdEmpregados(setores.get(codigo).getQtdEmpregados());
            setores.replace(codigo, setor);
        } else {
            throw new Exception("Setor não encontrado");
        }
    }

    public void delete(int codigo) throws Exception {
        if (!setores.isEmpty()) {
            if (setores.containsKey(codigo)) {
                if (setores.get(codigo).getQtdEmpregados() == 0) {
                    setores.remove(codigo);
                } else {
                    throw new Exception("Não foi possível excluir o setor pois há pessoas relacionadas a ele.");
                }
            } else {
                throw new Exception("Setor não encontrado.");
            }
        } else {
            throw new Exception("Sem setores cadastrados.");
        }
    }

    public Setor get(int codigo) throws Exception {
        if (!setores.isEmpty()) {
            if (setores.containsKey(codigo)) {
                return setores.get(codigo);
            } else {
                throw new Exception("Setor não encontrado.");
            }
        } else {
            throw new Exception("Nenhum setor cadastrado");
        }
    }

    public HashMap<Integer, Setor> getAll() {
        return setores;
    }

    public void addIntegrante(int codigo, Pessoa pessoa) throws Exception {
        try {
            Setor setor = get(codigo);
            setor.addIntegrante(pessoa);
            pessoa.setSetor(setor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void removeIntegrante(int codigo, Pessoa pessoa) throws Exception {
        try{
            Setor setor = get(codigo);
            if(setor.getIntegrantes().contains(pessoa)){
                setor.removeIntegrante(pessoa);
                pessoa.setSetor(null);
            } else {
                throw new Exception("Pessoa informada não faz parte do setor.");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
