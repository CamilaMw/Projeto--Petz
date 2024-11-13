package Main;

/**
 * Classe com os dados do produto
 *
 * @author Camila
 */
public class Produto {

    private int codigo;
    public String nome;
    public Double precoCompra;
    public Double precoVenda;
    public int quantidade;
    public int id;

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }

    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

 
    public String toString() {
        return getNome();
    }

 
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
