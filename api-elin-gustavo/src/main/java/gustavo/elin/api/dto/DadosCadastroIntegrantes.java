package gustavo.elin.api.dto;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroIntegrantes(
        @NotBlank
        String franquia,

        @NotBlank
        String nome,

        @NotBlank
        String funcao
) {
}
