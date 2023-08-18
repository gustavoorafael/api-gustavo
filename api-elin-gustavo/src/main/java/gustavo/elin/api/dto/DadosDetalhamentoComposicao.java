package gustavo.elin.api.dto;


import gustavo.elin.api.model.ComposicaoTime;

public record DadosDetalhamentoComposicao(Long id, Long idTime, Long idIntegrante) {

    public DadosDetalhamentoComposicao(ComposicaoTime composicaoTime){
        this(composicaoTime.getId(), composicaoTime.getTime().getId(), composicaoTime.getIntegrante().getId());
    }

}
