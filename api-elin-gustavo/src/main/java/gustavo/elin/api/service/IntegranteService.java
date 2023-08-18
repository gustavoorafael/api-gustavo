package gustavo.elin.api.service;

import gustavo.elin.api.dto.DadosAtualizacaoIntegrantes;
import gustavo.elin.api.dto.DadosCadastroIntegrantes;
import gustavo.elin.api.dto.DadosDetalhamentoIntegrante;
import gustavo.elin.api.dto.DadosListagemIntegrantes;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;


    public DadosDetalhamentoIntegrante cadastrarIntegrante(DadosCadastroIntegrantes dados){
        var integrante = new Integrante(dados.franquia(), dados.nome(), dados.funcao());
        integranteRepository.save(integrante);
        return new DadosDetalhamentoIntegrante(integrante);
    }

    public Page<DadosListagemIntegrantes> listarIntegrante(Pageable paginacao) {
        var page = integranteRepository.findAll(paginacao).map(DadosListagemIntegrantes::new);

        return page;
    }

    public DadosDetalhamentoIntegrante atualizarIntegrante(DadosAtualizacaoIntegrantes dados) {
        var integrante = integranteRepository.getReferenceById(dados.id());
        Integrante integranteAtualizado = integrante;
        if(dados.franquia() != null){
            integranteAtualizado.setFranquia(dados.franquia());
        }
        if(dados.nome() != null){
            integranteAtualizado.setNome(dados.nome());
        }
        if(dados.funcao() != null){
            integranteAtualizado.setFuncao(dados.funcao());
        }
        return new DadosDetalhamentoIntegrante(integranteAtualizado);
    }
    public void excluirIntegrante(Long id) {
        integranteRepository.deleteById(id);
    }
    public DadosDetalhamentoIntegrante detalharIntegrante(Long id){
        var integrante = integranteRepository.getReferenceById(id);
        return new DadosDetalhamentoIntegrante(integrante);
    }

}
