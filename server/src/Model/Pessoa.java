package Model;

public class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private Setor setor;

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        this.nome = nome;
        return true;
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean setEndereco(String endereco) {
        this.endereco = endereco;
        return true;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return cpf + ", " + nome + ", " + endereco;
    }
}
