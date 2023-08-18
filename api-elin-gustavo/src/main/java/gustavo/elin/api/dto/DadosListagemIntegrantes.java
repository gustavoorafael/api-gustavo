package gustavo.elin.api.dto;

import gustavo.elin.api.model.Integrante;

public record DadosListagemIntegrantes(Long id, String Franquia, String Nome, String Funcao) {
    public DadosListagemIntegrantes (Integrante integrante){
        this(integrante.getId(), integrante.getFranquia(), integrante.getNome(), integrante.getFuncao());
    }
}
