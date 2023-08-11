package Model;

import java.util.ArrayList;
import java.util.List;

public class Setor {

    private String nomeSetor;
    private String nomeEmpresa;
    private int qtdEmpregados;
    private List<Pessoa> integrantes = new ArrayList<>();

    public Setor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public void addIntegrante(Pessoa p){
        integrantes.add(p);
    }

    public void removeIntegrante(Pessoa p){
        integrantes.remove(p);
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public boolean setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
        return true;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public boolean setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        return true;
    }

    public int getQtdEmpregados() {
        return qtdEmpregados;
    }

    public boolean setQtdEmpregados(int qtdEmpregados) {
        this.qtdEmpregados = qtdEmpregados;
        return true;
    }

    @Override
    public String toString() {
        return nomeEmpresa + ", " + nomeSetor + ", Nº Funcionários: " + qtdEmpregados;
    }

    public String toString(int codigo) {
        return nomeEmpresa + ": " + codigo + " - " + " nomeSetor";
    }
}
