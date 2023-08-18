package gustavo.elin.api.dto;

import java.time.LocalDate;

public record DadosDatas(
        LocalDate dataInicial,
        LocalDate dataFinal
) {
}
