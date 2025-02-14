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

    /**
     * Método para adicionar um Usuario novo
     * @param usuarioRequest
     * @return DTO de resposta do Usuario
     */
    public UsuarioResponse adicionarUsuario (UsuarioRequest usuarioRequest) {
        Usuario usuario = repository.save(usuarioRequest.toEntity());
        return usuario.toDTO();
    }

    /**
     * Método para listar todos os Usuarios
     * @return Lista de DTO's de response do Usuario
     */
    public List<UsuarioResponse> buscarUsuarios () {
        return repository.findAll().stream().map(Usuario::toDTO).collect(Collectors.toList());
    }

    /**
     * Método para buscar um Usuario especifico
     * @param id
     * @return DTO de resposta do Usuario encontrado
     */
    public UsuarioResponse buscarUsuarioResponseId(Integer id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return usuario.toDTO();
    }

    /**
     * Método para deletar um Usuario especifico
     * @param id
     * @return void
     */
    public void deletarUsuario(Integer id) {
        buscarUsuarioResponseId(id);
        repository.deleteById(id);
    }

    /**
     * Método para editar um Usuario especifico
     * @param usuarioRequest
     * @param id
     * @return DTO de resposta do Usuario encontrado
     */
    public UsuarioResponse atualizarUsuario(UsuarioRequest usuarioRequest, Integer id) {
        buscarUsuarioResponseId(id);

        Usuario usuario = usuarioRequest.toEntity();
        usuario.setId(id);
        repository.save(usuario);
        return usuario.toDTO();
    }

    /**
     * Método para buscar um Usuario especifico
     * @param id
     * @return Entidade do Usuario encontrado
     */
    public Usuario buscarUsuarioID (Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
