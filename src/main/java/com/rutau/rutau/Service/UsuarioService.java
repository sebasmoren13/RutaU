package com.rutau.rutau.Service;

import com.rutau.rutau.Entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorCorreo(String correo);
    List<Usuario> listarTodos();
    void actualizarEstado(Long idUsuario, String nuevoEstado);
    void asignarRol(Long idUsuario, String nuevoRol);
    void incrementarNoShows(Long idUsuario);
}