package gustavo.elin.api.service;

import gustavo.elin.api.dto.DadosAtualizacaoTime;
import gustavo.elin.api.dto.DadosCadastroTime;
import gustavo.elin.api.dto.DadosDetalhamentoTime;
import gustavo.elin.api.dto.DadosListagemTimes;
import gustavo.elin.api.model.Time;
import gustavo.elin.api.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public DadosDetalhamentoTime cadastrarTime(DadosCadastroTime dados){
        var time = new Time(dados.data());
        repository.save(time);
        return new DadosDetalhamentoTime(time);
    }

    public Page<DadosListagemTimes> listarTime(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTimes::new);
        return page;
    }

    public DadosDetalhamentoTime atualizarTime(DadosAtualizacaoTime dados) {
        var time = repository.getReferenceById(dados.id());
        Time timeAtualizado = time;
        if(dados.data() != null) {
            timeAtualizado.setData(dados.data());
        }
        return new DadosDetalhamentoTime(timeAtualizado);
    }

    public void excluirTime(Long id) {
        repository.deleteById(id);
    }
    public DadosDetalhamentoTime detalharTime(Long id){
        var time = repository.getReferenceById(id);
        return new DadosDetalhamentoTime(time);
    }

}
