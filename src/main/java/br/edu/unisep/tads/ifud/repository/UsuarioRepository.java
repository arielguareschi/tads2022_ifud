package br.edu.unisep.tads.ifud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unisep.tads.ifud.model.Usuario;

@Repository
public interface UsuarioRepository 
    extends JpaRepository<Usuario, Long> {
        Optional<Usuario> findByUsername(String userName);
        Boolean existsByUserName(String userName);
        Boolean existsByEmail(String email);
}
