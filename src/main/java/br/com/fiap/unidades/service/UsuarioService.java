package br.com.fiap.unidades.service;

import br.com.fiap.unidades.dto.reponse.PessoaResponse;
import br.com.fiap.unidades.dto.reponse.UsuarioResponse;
import br.com.fiap.unidades.dto.request.UsuarioRequest;
import br.com.fiap.unidades.entity.Pessoa;
import br.com.fiap.unidades.entity.Usuario;
import br.com.fiap.unidades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse>{

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Usuario toEntity(UsuarioRequest r) {

        Pessoa pessoa = new PessoaService().toEntity(r.pessoa());

        return Usuario.builder()
                .username(r.username())
                .password(r.password())
                .pessoa(pessoa).build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {
        if(Objects.isNull(e)) return null;
        PessoaResponse pessoa = new PessoaService().toResponse(e.getPessoa());

        return UsuarioResponse.builder()
                .id(e.getId())
                .username(e.getUsername())
                .pessoa(pessoa).build();
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Usuario> findAll(Example<Usuario> example) {
        return repo.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario e) {
        System.out.println(e);return repo.save(e);
    }
}
