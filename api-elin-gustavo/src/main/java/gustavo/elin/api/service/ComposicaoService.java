package gustavo.elin.api.service;

import gustavo.elin.api.dto.DadosCadastroComposicao;
import gustavo.elin.api.dto.DadosDetalhamentoComposicao;
import gustavo.elin.api.dto.DadosListagemComposicao;
import gustavo.elin.api.model.ComposicaoTime;
import gustavo.elin.api.repository.ComposicaoRepository;
import gustavo.elin.api.repository.IntegranteRepository;
import gustavo.elin.api.repository.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComposicaoService {
    @Autowired
    private ComposicaoRepository composicaoRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    public DadosDetalhamentoComposicao cadastrarComposicao(@Valid DadosCadastroComposicao dados){
        var time = timeRepository.getReferenceById(dados.idTime());
        var integrante = integranteRepository.getReferenceById(dados.idIntegrante());
        var composicaoTime = new ComposicaoTime(null, time, integrante);
        composicaoRepository.save(composicaoTime);
        return new DadosDetalhamentoComposicao(composicaoTime);
    }

    public Page<DadosListagemComposicao> listarComposicao(Pageable paginacao) {
        var page = composicaoRepository.findAll(paginacao).map(DadosListagemComposicao::new);
        return page;
    }

    public void excluirComposicao(Long id) {
        composicaoRepository.deleteById(id);
    }
}

