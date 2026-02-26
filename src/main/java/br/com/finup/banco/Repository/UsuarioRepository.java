package br.com.finup.banco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.finup.banco.Model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Esse método mágico cria o SQL "SELECT * FROM usuarios WHERE username = ?" sozinho!
    Optional<Usuario> findByUsername(String username);
}