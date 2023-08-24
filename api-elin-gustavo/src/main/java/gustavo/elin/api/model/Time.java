package gustavo.elin.api.model;

import gustavo.elin.api.dto.DadosCadastroTime;
import gustavo.elin.api.dto.DadosTime;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Table(name = "time")
@Entity(name = "Time")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
}

