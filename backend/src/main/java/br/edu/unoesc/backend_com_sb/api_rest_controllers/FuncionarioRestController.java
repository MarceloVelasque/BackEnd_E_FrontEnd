package br.edu.unoesc.backend_com_sb.api_rest_controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.backend_com_sb.model.Funcionario;

@RestController
@RequestMapping(value = "/api")
public class FuncionarioRestController {
	Funcionario p1 = new Funcionario(1L, "João", 5, new BigDecimal("3000.00"));
	Funcionario p2 = new Funcionario(2L, "Felipe", 6, new BigDecimal("2000.00"));
	Funcionario p3 = new Funcionario(3L, "Marcelo", 7, new BigDecimal("8500.00"));
	Funcionario p4 = new Funcionario(4L, "Ana", 8, new BigDecimal("2000.00"));
	List<Funcionario> funcionarios;

	public FuncionarioRestController() {
		funcionarios = new ArrayList<Funcionario>();

		funcionarios.add(p1);
		funcionarios.add(p2);
		funcionarios.add(p3);
		funcionarios.add(p4);
		
	}

	// Incluir produto
	@PostMapping("/funcionario")
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		System.out.println("Inserindo um novo funcionario...");
		System.out.println(funcionario);

		funcionarios.add(funcionario);

		System.out.println(this.listarFuncionarios());

		return funcionario;
	}

	// Alterar produto
	@PutMapping("/funcionarios")
	public Funcionario atualizarFuncionarios(@RequestBody Funcionario funcionario) {
		Funcionario p = findById(funcionario.getId());
		System.out.println(p);

		p.setId(funcionario.getId());
		p.setNome(funcionario.getNome());
		p.setNumeroDeDependentes(funcionario.getNumeroDeDependentes());
		p.setSalario(funcionario.getSalario());

		System.out.println("Atualizando o Funcionario...");
		System.out.println(p);

		System.out.println(this.listarFuncionarios());

		return p;
	}

	// Excluir produto
	@DeleteMapping(value = "/funcionarios/{id}")
	public void deletarFuncionarios(@PathVariable Long id) {
		Funcionario p = findById(id);
		System.out.println(p);

		funcionarios.remove(p);

		System.out.println("Excluindo funcionario [" + id + "]...");

		System.out.println(this.listarFuncionarios());
	}

	@GetMapping(value = "/funcionarios")
	public List<Funcionario> listarFuncionarios() {
		return funcionarios;
	}

	@GetMapping(value = "/funcionarios/{id}")
	public Funcionario findById(@PathVariable Long id) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId().equals(id)) {
				return funcionario;
			}
		}

		return null;
	}
}
