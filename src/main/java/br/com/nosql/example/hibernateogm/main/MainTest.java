package br.com.nosql.example.hibernateogm.main;

import java.util.Date;
import java.util.List;

import br.com.nosql.example.hibernateogm.dao.ClienteDAO;
import br.com.nosql.example.hibernateogm.model.Cidade;
import br.com.nosql.example.hibernateogm.model.Cliente;
import br.com.nosql.example.hibernateogm.model.Historico;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		ClienteDAO clienteDAO = new ClienteDAO();
		for(int x=0; x < 100; x++){
			Cliente cliente = new Cliente();
			cliente.setBairro("Victor Konder");
			cliente.setCidade(new Cidade("Blumenau","99999 -"+String.format("%03d", x), "SC"));
			cliente.setEndereco("Av. São Paulo");
			for(int i=0; i< 10; i++){
				Historico historico = new Historico();
				historico.setDescricao("Histórico de teste "+String.format("%03d", i));
				historico.setRegistro(new Date());
				cliente.getHistoricos().add(historico);
			}
			cliente.setNome("Cliente "+String.format("%03d", x));
			cliente.setNumero(String.format("%03d", x));
			cliente.setTelefone("+55 (0x00)0000-0000");
			System.out.println("Posicao: "+String.format("%03d", x));
			clienteDAO.save(cliente);
		}
		List<Cliente> clientes = clienteDAO.findAll();
		for(Cliente cliente : clientes)
			System.out.println(cliente);
	}
}
