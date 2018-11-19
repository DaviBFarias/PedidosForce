package force.pedidos.pedidosforce.dominio;

import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProdutoTest {

    @org.junit.Test
    public void testObjetoProdutoCriadoComSucesso() {
        System.out.println("Instanciando a classe Produto");
        Produto pr = new Produto();

        System.out.println("Atribuindo valores a todos os atributos da classe criada.");
        pr.setNomeProduto("Produto Teste");
        pr.setCodigoProduto(001);
        ArrayList<Produto> arr = new ArrayList<Produto>();
        arr.add(new Produto());
        pr.setArrayProduto(arr);

        System.out.println("Validando que todos os atributos do objeto receberam o valor correto.");
        assertEquals("", "Produto Teste", pr.getNomeProduto());
        if(pr.getCodigoProduto() != 001){
            Assert.fail("Falha na Criação na validação do código do produto");
        }
        assertSame(arr, pr.getArrayProduto());

        System.out.println("Criação do objeto Produto validada com sucesso");

    }
}