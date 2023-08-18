package gustavo.elin.api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTime(
        @NotNull
        LocalDate data
) {
}
