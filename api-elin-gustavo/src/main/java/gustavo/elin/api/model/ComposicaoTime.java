package gustavo.elin.api.model;

import gustavo.elin.api.dto.DadosCadastroComposicao;
import gustavo.elin.api.dto.DadosComposicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;


@Entity
@Table(name = "composicao")
@Getter
@AllArgsConstructor
public class ComposicaoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Time")
    private Time time = new Time();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Integrante")
    private Integrante integrante = new Integrante();

    public ComposicaoTime() {
    }

    public ComposicaoTime(DadosComposicao dadosComposicao) {
        this.time.setId(dadosComposicao.idTime());
        this.integrante.setId(dadosComposicao.idIntegrante());
    }


    public ComposicaoTime(DadosCadastroComposicao dadosCadastroComposicao) {
    }
}

