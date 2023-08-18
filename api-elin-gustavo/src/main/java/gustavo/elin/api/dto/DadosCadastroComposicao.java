package gustavo.elin.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroComposicao(
        @NotNull
        Long idTime,
        @NotNull
        Long idIntegrante
)
{
}
