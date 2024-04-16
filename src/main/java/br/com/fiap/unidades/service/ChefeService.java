package br.com.fiap.unidades.service;

import br.com.fiap.unidades.dto.reponse.ChefeResponse;
import br.com.fiap.unidades.dto.reponse.UnidadeResponse;
import br.com.fiap.unidades.dto.request.ChefeRequest;
import br.com.fiap.unidades.dto.request.UnidadeRequest;
import br.com.fiap.unidades.entity.Chefe;
import br.com.fiap.unidades.entity.Unidade;
import br.com.fiap.unidades.repository.ChefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChefeService implements ServiceDTO<Chefe, ChefeRequest, ChefeResponse>{
    @Autowired
    private ChefeRepository repo;


    @Override
    public Chefe toEntity(ChefeRequest r) {

        var usuario = new UsuarioService().findById(r.usuario().id());
        var unidade = new UnidadeService().findById(r.unidade().id());

        if(Objects.isNull(usuario) || Objects.isNull(unidade)) {
            return null;
        }
        return Chefe.builder()
                .fim(r.fim())
                .inicio(r.inicio())
                .usuario(usuario)
                .unidade(unidade)
                .build();
    }

    @Override
    public ChefeResponse toResponse(Chefe e) {
        return null;
    }

    @Override
    public List<Chefe> findAll() {
        return List.of();
    }

    @Override
    public List<Chefe> findAll(Example<Chefe> example) {
        return List.of();
    }

    @Override
    public Chefe findById(Long id) {
        return null;
    }

    @Override
    public Chefe save(Chefe e) {
        return null;
    }
}
