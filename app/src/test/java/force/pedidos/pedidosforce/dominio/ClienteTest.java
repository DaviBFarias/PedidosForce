package force.pedidos.pedidosforce.dominio;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void testObjetoClienteCriadoComSucesso() {

        System.out.println("Instanciando a classe Cliente");
        Cliente cl = new Cliente();

        System.out.println("Atribuindo valores a todos os atributos da classe criada.");
        cl.setCgcCpf("12345678910");
        cl.setTipoCliente("PF");
        cl.setCEP("520212230");
        cl.setCidade("Cabrobró");
        cl.setEndereco("Rua Manoel Gusmão");
        cl.setNomeCliente("Nome Teste");

        System.out.println("Validando que todos os atributos do objeto receberam o valor correto.");

        assertEquals("","12345678910", cl.getCgcCpf());
        assertEquals("","520212230", cl.getCEP());
        assertEquals("","PF", cl.getTipoCliente());
        assertEquals("","Cabrobró", cl.getCidade());
        assertEquals("","Rua Manoel Gusmão", cl.getEndereco());
        assertEquals("","Nome Teste", cl.getNomeCliente());
        System.out.println("Criação do objeto Cliente validada com sucesso");

        //Assert.fail("Falha na Criação do objeto Cliente validada com sucesso");
    }

    @Test
    public void testeCadastrarClienteBanco(){

    }
}
