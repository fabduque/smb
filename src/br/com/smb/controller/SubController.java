package br.com.smb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.smb.dao.CategoriaDao;
import br.com.smb.dao.SubCategoriaDao;
import br.com.smb.modelo.SubCategoria;

@Controller
public class SubController {
	
	private final SubCategoriaDao dao;
	private final CategoriaDao daocat;
	
	@Autowired
	public SubController(SubCategoriaDao dao, CategoriaDao daocat) {
		this.dao = dao;
		this.daocat = daocat;
	}

	@RequestMapping("novaSub")
	public String form(Model model) {
		model.addAttribute("cat", daocat.lista());
		return "sub/cadSub";
	}
	
	@RequestMapping("adicionaSub")
	public ModelAndView adiciona(@Valid SubCategoria sub, BindingResult result, RedirectAttributes redirectAttributes) {

		if(result.hasFieldErrors("dsSub")) {
			//return "sub/cadSub" ;
		}

		dao.adiciona(sub);
		redirectAttributes.addFlashAttribute("sucesso", "Cadastrado com sucesso");
		//return "sub/listaSub";
		return new ModelAndView("redirect:listaSub");
	}
	
	@RequestMapping("listaSub")
	public String lista(Model model) {
		model.addAttribute("sub", dao.lista());
		return "sub/listaSub";
	}
	
	@RequestMapping("excluiSub")
	public String exclui(SubCategoria sub) {
		dao.exclui(sub);
		return "redirect:listaSub";
	}
	
	@RequestMapping("alteraSub")
	public String altera(SubCategoria sub) {
		dao.altera(sub);
		return "redirect:listaSub";
	}
	
	@RequestMapping("mostraSub")
	public String mostra(Long idSub, Model model) {
		model.addAttribute("sub", dao.buscaPorId(idSub));
		return "sub/alteraSub";
	}

}
