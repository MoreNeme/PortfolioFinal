
package com.portfolio.mnc.Security.Service;

import com.portfolio.mnc.Security.Entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.mnc.Security.Repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository usuarioRepository;
    
    public Optional<Usuario>getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByEmail(String email){
        return usuarioRepository.existsByEmail(email);
        
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
