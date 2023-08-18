package gustavo.elin.api.dto;

import gustavo.elin.api.model.Time;

import java.time.LocalDate;

public record DadosListagemTimes(Long id, LocalDate data) {

    public DadosListagemTimes(Time time){
        this(time.getId(), time.getData());
    }

}
