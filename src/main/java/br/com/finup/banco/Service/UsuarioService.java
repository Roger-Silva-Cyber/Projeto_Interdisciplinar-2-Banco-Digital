package br.com.finup.banco.Service;

import br.com.finup.banco.Model.Usuario;
import br.com.finup.banco.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Importante para criptografar a senha!

    // Método para LOGIN (Já estava pronto)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.withUsername(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }

    // --- NOVO: Método para CADASTRAR ---
    public void cadastrarUsuario(Usuario usuario) {
        // 1. Criptografar a senha antes de salvar (Segurança básica!) 🔒
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        // 2. Gerar Agência (ex: 4 dígitos) e Conta (ex: 8 dígitos) 🎲
        usuario.setAgencia(gerarNumeroAleatorio(4));
        usuario.setConta(gerarNumeroAleatorio(8));

        // 3. Salvar no banco
        repository.save(usuario);
    }

    // Método auxiliar que gera os números
    private String gerarNumeroAleatorio(int tamanho) {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();

        // Repete o processo "tamanho" vezes (ex: 4 vezes para agência)
        for (int i = 0; i < tamanho; i++) {
            int digito = random.nextInt(10); // Gera um número de 0 a 9
            numero.append(digito); // Adiciona o dígito na sequência
        }

        return numero.toString();
    }
}