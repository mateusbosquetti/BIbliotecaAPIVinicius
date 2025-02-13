package net.weg.bibliotecaapi.Service;

import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.UsuarioRequest;
import net.weg.bibliotecaapi.DTO.Request.UsuarioRequest;
import net.weg.bibliotecaapi.DTO.Response.UsuarioResponse;
import net.weg.bibliotecaapi.DTO.Response.UsuarioResponse;
import net.weg.bibliotecaapi.Entity.Usuario;
import net.weg.bibliotecaapi.Entity.Usuario;
import net.weg.bibliotecaapi.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioResponse adicionarUsuario (UsuarioRequest usuarioRequest) {
        Usuario usuario = repository.save(usuarioRequest.toEntity());
        return usuario.toDTO();
    }

    public List<UsuarioResponse> buscarUsuarios () {
        return repository.findAll().stream().map(Usuario::toDTO).collect(Collectors.toList());
    }

    public UsuarioResponse buscarUsuarioResponseId(Integer id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return usuario.toDTO();
    }

    public void deletarUsuario(Integer id) {
        buscarUsuarioResponseId(id);
        repository.deleteById(id);
    }

    public UsuarioResponse atualizarUsuario(UsuarioRequest usuarioRequest, Integer id) {
        buscarUsuarioResponseId(id);

        Usuario usuario = usuarioRequest.toEntity();
        usuario.setId(id);
        repository.save(usuario);
        return usuario.toDTO();
    }
    
    public Usuario buscarUsuarioID (Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
