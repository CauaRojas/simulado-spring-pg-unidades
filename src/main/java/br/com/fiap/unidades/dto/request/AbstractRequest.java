package br.com.fiap.unidades.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AbstractRequest(
        @Min(0)
        @NotNull(message = "Id é obrigatório")
        Long id
) {
}
