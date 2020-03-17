package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Aluno;
import br.usjt.hellospringboot.repository.AlunosRepository;

@Controller
public class AlunosController {
	//a injeção de dependência ocorre aqui
	@Autowired
	private AlunosRepository alunosRepo;
	
	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		
		//passe o nome da pagina ao contrutor
		ModelAndView mv = new ModelAndView("lista_alunos");
		
		//Busque a coleção com o repositório
		List<Aluno> alunos = alunosRepo.findAll();
		
		//Adicione a coleção ao objeto ModelAndView
		mv.addObject("alunos", alunos);
		
		//devolva o ModelAndView
		return mv;
		
	}
	
}
