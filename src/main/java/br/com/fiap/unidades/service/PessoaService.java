package br.com.fiap.unidades.service;

import br.com.fiap.unidades.dto.reponse.PessoaResponse;
import br.com.fiap.unidades.dto.request.PessoaRequest;
import br.com.fiap.unidades.entity.Pessoa;
import br.com.fiap.unidades.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PessoaService implements ServiceDTO<Pessoa, PessoaRequest, PessoaResponse>{

    @Autowired
    private PessoaRepository repo;

    @Override
    public Pessoa toEntity(PessoaRequest r) {
        return Pessoa.builder()
                .nome(r.nome())
                .tipo(r.tipo())
                .nascimento(r.nascimento())
                .email(r.email())
                .sobrenome(r.sobrenome())
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa e) {
        if(Objects.isNull(e)) return null;
        return PessoaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .tipo(e.getTipo())
                .nascimento(e.getNascimento())
                .email(e.getEmail())
                .sobrenome(e.getSobrenome())
                .build();
    }

    @Override
    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Pessoa> findAll(Example<Pessoa> example) {
        return repo.findAll(example);
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Pessoa save(Pessoa e) {
        return repo.save(e);
    }
}
