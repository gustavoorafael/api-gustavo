package gustavo.elin.api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosData(
        @NotNull
        LocalDate data
) {
}
