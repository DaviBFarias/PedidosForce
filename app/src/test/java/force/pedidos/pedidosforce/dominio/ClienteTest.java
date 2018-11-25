package force.pedidos.pedidosforce.dominio;

import org.junit.Test;

import force.pedidos.pedidosforce.data.ConexaoCliente;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    Cliente cl = new Cliente();
    ConexaoCliente cn = new ConexaoCliente();

    @Test
    public void testObjetoClienteCriadoComSucesso() {

        System.out.println("Instanciando teste da classe Cliente...");
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
    }

    @Test
    public void testCadastrarCliente(){
        cn.cadastrarCliente(cl.getNomeCliente(), cl.getCgcCpf(), cl.getTipoCliente(), cl.getEndereco(),
                cl.getCidade(), cl.getUF(), cl.getCEP());
    }

    @Test
    public void testGetCliente(){
        Cliente clBanco = cn.getCliente(cl.getCgcCpf());
        assertEquals("","12345678910", clBanco.getCgcCpf());
        assertEquals("","520212230", clBanco.getCEP());
        assertEquals("","PF", clBanco.getTipoCliente());
        assertEquals("","Cabrobró", clBanco.getCidade());
        assertEquals("","Rua Manoel Gusmão", clBanco.getEndereco());
        assertEquals("","Nome Teste", clBanco.getNomeCliente());
    }
}
