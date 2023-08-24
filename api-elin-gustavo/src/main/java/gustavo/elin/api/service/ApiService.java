package gustavo.elin.api.service;

import gustavo.elin.api.dto.DadosData;
import gustavo.elin.api.dto.DadosDatas;
import gustavo.elin.api.model.ComposicaoTime;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.model.Time;
import gustavo.elin.api.repository.ComposicaoRepository;
import gustavo.elin.api.repository.IntegranteRepository;
import gustavo.elin.api.repository.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    @Autowired
    private ComposicaoRepository composicaoRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    public List<Integrante> buscarIntegrantes() {
        return integranteRepository.findAll();
    }

    public List<Time> buscarTimes() {
        return timeRepository.findAll();
    }

    public List<ComposicaoTime> buscarComposicao() {
        return composicaoRepository.findAll();
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
    public List<String> timeDaData(DadosData dados) {
        List<String> nomesIntegrantes = new ArrayList<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            if (composicao.getTime().getData().isEqual(dados.data())) {
                nomesIntegrantes.add(composicao.getIntegrante().getNome());
            }
        }
        return nomesIntegrantes;
    }

    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public String integranteMaisUsado(DadosDatas dados) {
        Map<String, Integer> integranteQuantidade = new HashMap<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                String nomeIntegrante = composicao.getIntegrante().getNome();
                Integer quantidade = integranteQuantidade.getOrDefault(nomeIntegrante, 0);
                integranteQuantidade.put(nomeIntegrante, quantidade + 1);
            }
        }
        String integranteMaisUsado = null;
        int maiorQuantidade = 0;
        for (Map.Entry<String, Integer> resultado : integranteQuantidade.entrySet()) {
            if (resultado.getValue() > maiorQuantidade) {
                integranteMaisUsado = resultado.getKey();
                maiorQuantidade = resultado.getValue();
            }
        }
        return integranteMaisUsado;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(DadosDatas dados) {
        List<ComposicaoTime> composicoes = buscarComposicao();
        List<ComposicaoTime> composicoesPeriodo = new ArrayList<>();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                composicoesPeriodo.add(composicao);
            }
        }
        Map<Time, Integer> timeQuantidade = new HashMap<>();
        for (ComposicaoTime composicao : composicoesPeriodo) {
            Time time = composicao.getTime();
            Integer quantidade = timeQuantidade.getOrDefault(time, 0);
            timeQuantidade.put(time, quantidade + 1);
        }
        Time timeMaisUtilizado = null;
        int maiorQuantidade = 0;
        for (Map.Entry<Time, Integer> resultado : timeQuantidade.entrySet()) {
            if (resultado.getValue() > maiorQuantidade) {
                timeMaisUtilizado = resultado.getKey();
                maiorQuantidade = resultado.getValue();
            }
        }
        List<String> integrantesTimeMaisComum = new ArrayList<>();
        for (ComposicaoTime composicao : composicoesPeriodo) {
            if (composicao.getTime().equals(timeMaisUtilizado)) {
                integrantesTimeMaisComum.add(composicao.getIntegrante().getNome());
            }
        }
        return integrantesTimeMaisComum;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(DadosDatas dados) {
        Map<String, Integer> funcaoQuantidade = new HashMap<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                String funcaoIntegrante = composicao.getIntegrante().getFuncao();
                Integer quantidade = funcaoQuantidade.getOrDefault(funcaoIntegrante, 0);
                funcaoQuantidade.put(funcaoIntegrante, quantidade + 1);
            }
        }
        String funcaoMaisComum = null;
        int maiorQuantidade = 0;
        for (Map.Entry<String, Integer> resultado : funcaoQuantidade.entrySet()) {
            if (resultado.getValue() > maiorQuantidade) {
                funcaoMaisComum = resultado.getKey();
                maiorQuantidade = resultado.getValue();
            }
        }
        return funcaoMaisComum;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(DadosDatas dados) {
        Map<String, Integer> franquiaQuantidade = new HashMap<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                String franquia = composicao.getIntegrante().getFranquia();
                Integer frequencia = franquiaQuantidade.getOrDefault(franquia, 0);
                franquiaQuantidade.put(franquia, frequencia + 1);
            }
        }
        String franquia = null;
        int maiorFrequencia = 0;
        for (Map.Entry<String, Integer> resultado : franquiaQuantidade.entrySet()) {
            if (resultado.getValue() > maiorFrequencia) {
                franquia = resultado.getKey();
                maiorFrequencia = resultado.getValue();
            }
        }
        return franquia;
    }


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Integer> contagemPorFranquia(DadosDatas dados) {
        Map<String, Integer> franquiaQuantidade = new HashMap<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                String nomeFranquia = composicao.getIntegrante().getFranquia();
                Integer quantidade = franquiaQuantidade.getOrDefault(nomeFranquia, 0);
                franquiaQuantidade.put(nomeFranquia, quantidade + 1);
            }
        }
        Map<String, Integer> contagemFranquia = new HashMap<>();
        for (Map.Entry<String, Integer> resultado : franquiaQuantidade.entrySet()) {
            String nomeFranquia = resultado.getKey();
            Integer quantidade = resultado.getValue();
            contagemFranquia.put(nomeFranquia, quantidade);
        }
        return contagemFranquia;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Integer> contagemPorFuncao(DadosDatas dados) {
        Map<String, Integer> funcaoQuantidade = new HashMap<>();
        List<ComposicaoTime> composicoes = buscarComposicao();
        for (ComposicaoTime composicao : composicoes) {
            LocalDate dataTime = composicao.getTime().getData();
            if ((dados.dataInicial() == null || !dataTime.isBefore(dados.dataInicial()))
                    && (dados.dataFinal() == null || !dataTime.isAfter(dados.dataFinal()))) {
                String nomeFuncao = composicao.getIntegrante().getFuncao();
                Integer quantidade = funcaoQuantidade.getOrDefault(nomeFuncao, 0);
                funcaoQuantidade.put(nomeFuncao, quantidade + 1);
            }
        }
        Map<String, Integer> resultado = new HashMap<>();
        for (Map.Entry<String, Integer> entrada : funcaoQuantidade.entrySet()) {
            String nomeFuncao = entrada.getKey();
            Integer quantidade = entrada.getValue();
            resultado.put(nomeFuncao, quantidade);
        }
        return resultado;
    }
}

