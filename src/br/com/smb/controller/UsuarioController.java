package br.com.smb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.smb.dao.UsuarioDao;
import br.com.smb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private final UsuarioDao dao;
	
	@Autowired
	public UsuarioController(UsuarioDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/cadUsuario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result) {

		if(result.hasFieldErrors("nome")) {
			return "usuario/cadUsuario" ;
		}

		dao.adiciona(usuario);
		return "usuario/listaUsuarios";
	}
	
	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		model.addAttribute("usuarios", dao.lista());
		return "usuario/listaUsuarios";
	}
	
	@RequestMapping("excluiUsuario")
	public String exclui(Usuario usuario) {
		dao.exclui(usuario);
		return "redirect:listaUsuarios";
	}
	
	@RequestMapping("alteraUsuario")
	public String altera(Usuario usuario) {
		dao.altera(usuario);
		return "redirect:listaUsuarios";
	}
	
	@RequestMapping("mostraUsuario")
	public String mostra(Long id_user, Model model) {
		model.addAttribute("usuario", dao.buscaPorId(id_user));
		return "usuario/mostraUsuario";
	}

	@RequestMapping("exibeUsuario")
	public String ModalUsuario(Long id_user, Model model) {
		model.addAttribute("usuario", dao.buscaPorId(id_user));
		return "usuario/exibeUsuarioModal";
	}
	
}
