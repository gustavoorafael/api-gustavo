package gustavo.elin.api.dto;

import gustavo.elin.api.model.ComposicaoTime;

public record DadosListagemComposicao(Long id, Long idTime, Long idIntegrante) {

    public DadosListagemComposicao(ComposicaoTime composicaoTime){
        this(composicaoTime.getId(), composicaoTime.getTime().getId(), composicaoTime.getIntegrante().getId());
    }

}
