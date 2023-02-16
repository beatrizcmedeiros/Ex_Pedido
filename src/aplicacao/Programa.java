package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		cadastrarPedido();	
		sc.close();
	}

	private static void cadastrarPedido() throws ParseException {
		Pedido pedido = new Pedido();
		Cliente cliente = cadastrarCliente();
		
		StatusPedido status;
		int qtd_itens_pedido;
		
		System.out.print("\nInforme os dados do pedido:");
		System.out.print("\nStatus: ");
		status = StatusPedido.valueOf(sc.next());
		System.out.print("Quantos itens serão adicionados nesse pedido? ");
		qtd_itens_pedido = sc.nextInt();
		
		pedido = new Pedido(new Date(), status, cliente);
		
		for(int i = 1; i <= qtd_itens_pedido; i++) {
			String nome_produto;
			Double preco;
			Integer quantidade;
			
			System.out.printf("\nInforme os dados do item %d:\n", i);
			System.out.print("Nome do produto: ");
			sc.nextLine();
			nome_produto = sc.nextLine();
			System.out.print("Preço do produto: ");
			preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			quantidade = sc.nextInt();
			
			ItemPedido item = new ItemPedido(quantidade, preco, new Produto(nome_produto, preco));
						
			pedido.addItem(item);
		}
		
		resumoPedido(pedido);
	}

	private static Cliente cadastrarCliente() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String nome_cliente;
		String email;
		Date data_nascimento;
		
		System.out.print("Informe os dados do cliente:\n");
		System.out.print("Nome: ");
		nome_cliente = sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		data_nascimento = sdf.parse(sc.next());
		
		
		Cliente cliente = new Cliente(nome_cliente, email, data_nascimento);
		return cliente;
	}
	
	private static void resumoPedido(Pedido pedido) {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		sb.append("\nResumo do Pedido:");
		sb.append("\nMomento da realização do pedido: " + sdf1.format(pedido.getMomento()));
		sb.append("\nStatus do pedido: " + pedido.getStatus());
		sb.append("\nCliente: " + pedido.getCliente().getNome());
		sb.append(" (" + sdf2.format(pedido.getCliente().getData_aniversario()) + ") - " + pedido.getCliente().getEmail());
		sb.append("\nItens do pedido:");
		
		List<ItemPedido> itens = pedido.getItens();
		
		for(ItemPedido i : itens) {
			sb.append("\n" + i.toString());
		}
		
		sb.append("\nPreço total: " + pedido.total());
		
		System.out.println(sb);
	}
	
}// class Programa
