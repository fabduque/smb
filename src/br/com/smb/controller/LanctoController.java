package br.com.smb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.smb.dao.LanctosDao;
import br.com.smb.modelo.Lanctos;

@Controller
public class LanctoController {
	
	private final LanctosDao dao;
	
	@Autowired
	public LanctoController(LanctosDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novoLancto")
	public String form() {
		return "lanctos/cadLanctos";
	}
	
	@RequestMapping("adicionaLancto")
	public String adiciona(@Valid Lanctos lancto, BindingResult result) {

		if(result.hasFieldErrors("dsLancamento")) {
			return "lanctos/cadLancto" ;
		}

		dao.adiciona(lancto);
		return "lanctos/listaLanctos";
	}
	
	@RequestMapping("listaLanctos")
	public String lista(Model model) {
		model.addAttribute("lancto", dao.lista());
		return "lanctos/listaLanctos";
	}
	
	@RequestMapping("excluiLancto")
	public String exclui(Lanctos lancto) {
		dao.exclui(lancto);
		return "redirect:listaLanctos";
	}
	
	@RequestMapping("alteraLancto")
	public String altera(Lanctos lancto) {
		dao.altera(lancto);
		return "redirect:listaLanctos";
	}
	
	@RequestMapping("mostraLancto")
	public String mostra(Long idLancamento, Model model) {
		model.addAttribute("lancto", dao.buscaPorId(idLancamento));
		return "lanctos/mostraLancto";
	}


}
