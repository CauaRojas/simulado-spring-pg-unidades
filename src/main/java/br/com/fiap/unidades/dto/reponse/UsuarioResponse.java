package br.com.fiap.unidades.dto.reponse;

import lombok.Builder;

@Builder
public record UsuarioResponse(
        PessoaResponse pessoa,
        String username,
        Long id
) {
}
