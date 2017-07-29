package br.com.smb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.smb.dao.CategoriaDao;
import br.com.smb.modelo.Categoria;


@Controller
public class CategoriaController {
	
	private final CategoriaDao dao;
	
	@Autowired
	public CategoriaController(CategoriaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novaCategoria")
	public String form() {
		return "ccusto/cadCategoria";
	}
	
	@RequestMapping("adicionaCategoria")
	public String adiciona(@Valid Categoria categoria, BindingResult result) {

		if(result.hasFieldErrors("dsCategoria")) {
			return "ccusto/cadCategoria" ;
		}

		dao.adiciona(categoria);
		return "ccusto/listaCategoria";
	}
	
	@RequestMapping("listaCategoria")
	public String lista(Model model) {
		model.addAttribute("categoria", dao.lista());
		return "ccusto/listaCategoria";
	}
	
	@RequestMapping("excluiCategoria")
	public String exclui(Categoria categoria) {
		dao.exclui(categoria);
		return "redirect:listaCategoria";
	}
	
	@RequestMapping("alteraCategoria")
	public String altera(Categoria categoria) {
		dao.altera(categoria);
		return "redirect:listaCategoria";
	}
	
	@RequestMapping("mostraCategoria")
	public String mostra(Long idCategoria, Model model) {
		model.addAttribute("categoria", dao.buscaPorId(idCategoria));
		return "ccusto/alteraCategoria";
	}

}
