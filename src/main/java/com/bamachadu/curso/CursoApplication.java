package com.bamachadu.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.bamachadu.curso.entity.domain.Categoria;
import com.bamachadu.curso.entity.domain.Cidade;
import com.bamachadu.curso.entity.domain.Cliente;
import com.bamachadu.curso.entity.domain.Endereco;
import com.bamachadu.curso.entity.domain.Estado;
import com.bamachadu.curso.entity.domain.ItemPedido;
import com.bamachadu.curso.entity.domain.Pagamento;
import com.bamachadu.curso.entity.domain.PagamentoBoleto;
import com.bamachadu.curso.entity.domain.PagamentoCartao;
import com.bamachadu.curso.entity.domain.Pedido;
import com.bamachadu.curso.entity.domain.Produto;
import com.bamachadu.curso.entity.models.EstadoPagamento;
import com.bamachadu.curso.entity.models.TipoCliente;
import com.bamachadu.curso.repositories.CategoriaRepository;
import com.bamachadu.curso.repositories.CidadeRepository;
import com.bamachadu.curso.repositories.ClienteRepository;
import com.bamachadu.curso.repositories.EnderecoRepository;
import com.bamachadu.curso.repositories.EstadoRepository;
import com.bamachadu.curso.repositories.ItemPedidoRepository;
import com.bamachadu.curso.repositories.PagamentoRepository;
import com.bamachadu.curso.repositories.PedidoRepository;
import com.bamachadu.curso.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Administrativo");
		Categoria cat3 = new Categoria(null, "Administrativo2");
		Categoria cat4 = new Categoria(null, "Administrativo3");
		Categoria cat5 = new Categoria(null, "Administrativo4");
		Categoria cat6 = new Categoria(null, "Administrativo5");
		Categoria cat7 = new Categoria(null, "Administrativo6");
		Categoria cat8 = new Categoria(null, "Administrativo7");
		Categoria cat9 = new Categoria(null, "Administrativo8");
		Categoria cat10 = new Categoria(null, "Administrativo9");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12223233345", TipoCliente.PESSOA_FISICA);

		Endereco e1 = new Endereco(null, "rua  rua 1", "1", "apto", "centro", "31313131", cli1, c1);
		Endereco e2 = new Endereco(null, "rua  rua 2", "1", "apto", "centro", "31313131", cli1, c2);

		cli1.getTeleones().addAll(Arrays.asList("12345612", "12345555552"));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Pedido ped1 = new Pedido(null, simpleDateFormat.parse("30/09/2021 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, simpleDateFormat.parse("30/10/2021 10:32"), cli1, e2);

		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2,
				simpleDateFormat.parse("30/10/2021 10:32"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped1, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
