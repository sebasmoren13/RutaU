package com.rutau.rutau.Service.ServiceImpl;

import com.rutau.rutau.Entity.Usuario;
import com.rutau.rutau.Exception.ReglaNegocioException;
import com.rutau.rutau.Exception.ResourceNotFoundException;
import com.rutau.rutau.Repository.UsuarioRepository;
import com.rutau.rutau.Service.UsuarioService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new ReglaNegocioException("Ya existe un usuario con ese correo");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void actualizarEstado(Long usuarioId, String nuevoEstado) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        usuario.setEstado(nuevoEstado);
        usuarioRepository.save(usuario);
    }

    @Override
    public void asignarRol(Long usuarioId, String nuevoRol) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        usuario.setRol(nuevoRol);
        usuarioRepository.save(usuario);
    }

    @Override
    public void incrementarNoShows(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        int actual = usuario.getNoShowsCount() != null ? usuario.getNoShowsCount() : 0;
        usuario.setNoShowsCount(actual + 1);
        usuarioRepository.save(usuario);
    }
}