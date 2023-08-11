package Repository;

import Model.Setor;

import java.util.HashMap;
import java.util.List;

public class SetorRepository {

    private int sequence = 1;
    private HashMap<Integer, Setor> setores = new HashMap<Integer, Setor>();

    public void addSetor(Setor s){
        setores.put(sequence++, s);
    }

    public void removeSetor(int codigo){
        setores.remove(codigo);
    }

    public Setor getSetor(int codigo){
        return setores.get(codigo);
    }

    public List<Setor> getAllSetores(){
        return (List) setores.values();
    }

}
