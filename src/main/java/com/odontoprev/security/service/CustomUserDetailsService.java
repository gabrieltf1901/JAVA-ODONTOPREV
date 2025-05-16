package com.odontoprev.security.service;

import com.odontoprev.model.Usuario;
import com.odontoprev.repository.UsuarioRepository;
import com.odontoprev.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repo;

    public CustomUserDetailsService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usu = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        return User.withUsername(usu.getEmail())
                .password(usu.getSenha())
                .roles(usu.getRole().replace("ROLE_", ""))
                .build();
    }
}