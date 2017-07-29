package br.com.smb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.smb.dao.ContaDao;
import br.com.smb.modelo.Conta;

@Controller
public class ContaController {
	
	private final ContaDao dao;
	
	@Autowired
	public ContaController(ContaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novaConta")
	public String form() {
		return "conta/cadConta";
	}
	
	@RequestMapping("adicionaConta")
	public ModelAndView adiciona(@Valid Conta conta, BindingResult result, RedirectAttributes redirectAttributes) {

		dao.adiciona(conta);
		redirectAttributes.addFlashAttribute("sucesso", "Cadastrado com sucesso");
		//return "sub/listaSub";
		return new ModelAndView("redirect:listaConta");
	}
	
	@RequestMapping("listaConta")
	public String lista(Model model) {
		model.addAttribute("conta", dao.lista());
		return "conta/listaConta";
	}
	
	@RequestMapping("excluiConta")
	public String exclui(Conta conta) {
		dao.exclui(conta);
		return "redirect:listaConta";
	}
	
	@RequestMapping("alteraConta")
	public String altera(Conta conta) {
		dao.altera(conta);
		return "redirect:listaConta";
	}
	
	@RequestMapping("mostraConta")
	public String mostra(Long idConta, Model model) {
		model.addAttribute("conta", dao.buscaPorId(idConta));
		return "conta/alteraConta";
	}

}
