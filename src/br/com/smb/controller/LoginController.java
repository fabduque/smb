package br.com.smb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.smb.dao.LoginDao;
import br.com.smb.modelo.Login;


@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Login login, HttpSession session) {
		int valor = new LoginDao().existeUsuario(login);
		if(valor > 0) {
			session.setAttribute("usuarioLogado", login);
			session.setAttribute("idUsuarioLogado", valor);
			return "abertura";
		}
		return "redirect:loginForm";
		}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) { 
		session.invalidate();
		return "redirect:loginForm"; 
	}
	
}


