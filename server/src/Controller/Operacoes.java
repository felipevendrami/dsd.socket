package Controller;

import java.util.List;

public interface Operacoes {

    String OP_INSERT = "INSERT";
    String OP_UPDATE = "UPDATE";
    String OP_DELETE = "DELETE;";
    String OP_GET = "GET";

    void definirOperacao(String[] arrayDados);
    void insert(String[] arrayDados);
    void update(String[] arrayDados);
    void delete(String[] arrayDados);
    void get(String[] arrayDados);
}
