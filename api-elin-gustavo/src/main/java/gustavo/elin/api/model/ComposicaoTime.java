package gustavo.elin.api.model;

import gustavo.elin.api.dto.DadosCadastroComposicao;
import gustavo.elin.api.dto.DadosComposicao;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;


@Table(name = "composicao")
@Entity(name = "ComposicaoTime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ComposicaoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Time")
    private Time time = new Time();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Integrante")
    private Integrante integrante = new Integrante();



    public ComposicaoTime(DadosCadastroComposicao dadosComposicao) {
        this.time.setId(dadosComposicao.idTime());
        this.integrante.setId(dadosComposicao.idIntegrante());
    }
}

