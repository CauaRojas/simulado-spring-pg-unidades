package br.com.fiap.unidades.service;

import br.com.fiap.unidades.dto.reponse.ChefeResponse;
import br.com.fiap.unidades.dto.request.ChefeRequest;
import br.com.fiap.unidades.entity.Chefe;
import br.com.fiap.unidades.repository.ChefeRepository;
import br.com.fiap.unidades.repository.UnidadeRepository;
import br.com.fiap.unidades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChefeService implements ServiceDTO<Chefe, ChefeRequest, ChefeResponse>{
    @Autowired
    private ChefeRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;


    @Override
    public Chefe toEntity(ChefeRequest r) {

        var usuario = usuarioRepository.findById(r.usuario().id()).orElse(null);
        var unidade = unidadeRepository.findById(r.unidade().id()).orElse(null);

        if(Objects.isNull(usuario) || Objects.isNull(unidade)) {
            return null;
        }
        return Chefe.builder()
                .fim(r.fim())
                .inicio(r.inicio())
                .substituto(r.substituto())
                .usuario(usuario)
                .unidade(unidade)
                .build();
    }

    @Override
    public ChefeResponse toResponse(Chefe e) {
        if(Objects.isNull(e)) return null;

        return ChefeResponse.builder()
                .id(e.getId())
                .fim(e.getFim())
                .inicio(e.getInicio())
                .substituto(e.getSubstituto())
                .usuario(new UsuarioService().toResponse(e.getUsuario()))
                .unidade(new UnidadeService().toResponse(e.getUnidade()))
                .build();
    }

    @Override
    public List<Chefe> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Chefe> findAll(Example<Chefe> example) {
        return repo.findAll(example);
    }

    @Override
    public Chefe findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Chefe save(Chefe e) {
        return repo.save(e);
    }
}
