package gustavo.elin.api.model;

import gustavo.elin.api.dto.DadosCadastroIntegrantes;
import gustavo.elin.api.dto.DadosIntegrante;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Table(name = "integrante")
@Entity(name = "Integrante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String franquia;

    private String nome;

    private String funcao;

    public Integrante(String franquia, String nome, String funcao){
        this.franquia = franquia;
        this.nome = nome;
        this.funcao = funcao;
    }


    public Integrante(DadosCadastroIntegrantes dadosIntegrante) {
        this.franquia = dadosIntegrante.franquia();
        this.nome = dadosIntegrante.nome();
        this.funcao = dadosIntegrante.funcao();
    }
}



