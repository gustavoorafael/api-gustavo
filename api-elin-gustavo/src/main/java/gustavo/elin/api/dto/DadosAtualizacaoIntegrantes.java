package gustavo.elin.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoIntegrantes(
        @NotNull
        Long id,
        String franquia,
        String nome,
        String funcao
) {
}
