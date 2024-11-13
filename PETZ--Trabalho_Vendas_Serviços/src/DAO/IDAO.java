package DAO;

import java.util.ArrayList;

/**
 * Interface para classes de acesso a dados
 *
 * @author Camila
 */
public interface IDAO<Tipo> {

    public void inserir(Tipo objeto) throws Exception;

    public void alterar(Tipo objeto) throws Exception;

    public void excluir(int id) throws Exception;

    public ArrayList<Tipo> listarTodos() throws Exception;

    public Tipo recuperar(int codigo) throws Exception;
}
/* Essa interface é usada para criar classes de acesso a dados (DAO) em um sistema. DAO e o que separa a lógica de acesso a dados do restante da aplicação.

A interface IDAO tem métodos para operações básicas de acesso a dados, como inserir, alterar, excluir, listar todos e recuperar*/