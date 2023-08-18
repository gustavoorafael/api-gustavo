package gustavo.elin.api.model;

import gustavo.elin.api.dto.DadosCadastroTime;
import gustavo.elin.api.dto.DadosTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@EqualsAndHashCode(of = "id")
@Entity(name = "Time")
@Table(name = "time")
@Getter
@Setter

@AllArgsConstructor

public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    public Time(LocalDate data){
        this.data = data;
    }
    public Time(DadosCadastroTime dadosTime) {
        this.data = dadosTime.data();
    }
    public Time() {

    }
}

