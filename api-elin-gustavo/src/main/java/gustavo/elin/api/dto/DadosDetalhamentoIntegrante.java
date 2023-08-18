package gustavo.elin.api.dto;

import gustavo.elin.api.model.Integrante;

public record DadosDetalhamentoIntegrante(Long id, String franquia, String nome, String funcao) {
    public DadosDetalhamentoIntegrante(Integrante integrante){
        this(integrante.getId(), integrante.getFranquia(), integrante.getNome(), integrante.getFuncao());
    }

}