package br.com.fiap.unidades.dto.reponse;

import br.com.fiap.unidades.entity.Tipo;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PessoaResponse(
        Long id,
        String nome,
        Tipo tipo,
        LocalDate nascimento,
        String email,
        String sobrenome
) {
}
