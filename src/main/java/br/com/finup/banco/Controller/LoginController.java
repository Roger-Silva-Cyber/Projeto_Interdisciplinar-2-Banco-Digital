package br.com.finup.banco.Controller;

import br.com.finup.banco.Model.Usuario;
import br.com.finup.banco.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
@Autowired
    private br.com.finup.banco.Repository.UsuarioRepository usuarioRepository; // Precisamos do repositório aqui

    @GetMapping("/")
    public String home(org.springframework.ui.Model model, java.security.Principal principal) {
        // 1. Pega o username de quem está logado
        String username = principal.getName();
        
        // 2. Busca os dados completos no banco
        br.com.finup.banco.Model.Usuario usuario = usuarioRepository.findByUsername(username).get();
        
        // 3. Manda o objeto "usuario" para o HTML
        model.addAttribute("usuario", usuario);
        
        return "home";
    }
}