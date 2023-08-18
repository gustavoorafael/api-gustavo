package gustavo.elin.api.dto;

import gustavo.elin.api.model.Time;

import java.time.LocalDate;

public record DadosDetalhamentoTime(Long id, LocalDate data) {
    public DadosDetalhamentoTime(Time time){
        this(time.getId(), time.getData());
    }
}