package Controller;

public interface OperacoesController {

    void insert(String[] arrayDados);
    void update(String[] arrayDados);
    void delete(String[] arrayDados);
    void get(String[] arrayDados);
    void getAll();
}
