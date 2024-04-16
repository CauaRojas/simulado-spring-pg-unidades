package br.com.fiap.unidades.dto.reponse;

import lombok.Builder;

@Builder
public record UnidadeResponse(
        String nome,
        String sigla,
        String descricao,
        Long id,
        UnidadeResponse macro
) {
}
