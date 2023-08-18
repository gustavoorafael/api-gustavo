package gustavo.elin.api.controller;

import gustavo.elin.api.dto.DadosData;
import gustavo.elin.api.dto.DadosDatas;
import gustavo.elin.api.service.ApiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService service;

    @PostMapping("/time-da-data")
    @Transactional
    public ResponseEntity retornarTimeDaData(@RequestBody @Valid DadosData dados) {
        var timeDaData = service.timeDaData(dados);
        return ResponseEntity.ok(timeDaData);
    }

    @PostMapping("/integrante-mais-usado")
    @Transactional
    public ResponseEntity retornarIntegranteMaisUsado(@RequestBody DadosDatas dados){
        var integranteMaisUsado = service.integranteMaisUsado(dados);
        return ResponseEntity.ok(integranteMaisUsado);
    }

    @PostMapping("/time-mais-comum")
    @Transactional
    public ResponseEntity retornarTimeMaisComum(@RequestBody DadosDatas dados){
        var timeMaisComum = service.timeMaisComum(dados);
        return ResponseEntity.ok(timeMaisComum);
    }

    @PostMapping("/funcao-mais-comum")
    @Transactional
    public ResponseEntity retornarFuncaoMaisComum(@RequestBody DadosDatas dados){
        var funcaoMaisComum = service.funcaoMaisComum(dados);
        return ResponseEntity.ok(funcaoMaisComum);
    }

    @PostMapping("/franquia-mais-famosa")
    @Transactional
    public ResponseEntity retornarFranquiaMaisFamosa(@RequestBody DadosDatas dados){
        var franquiaMaisFamosa = service.franquiaMaisFamosa(dados);
        return ResponseEntity.ok(franquiaMaisFamosa);
    }

    @PostMapping("/contagem-por-franquia")
    @Transactional
    public ResponseEntity retornarContagemPorFranquia(@RequestBody DadosDatas dados){
        var contagemPorFranquia = service.contagemPorFranquia(dados);
        return ResponseEntity.ok(contagemPorFranquia);
    }

    @PostMapping("/contagem-por-funcao")
    @Transactional
    public ResponseEntity retornarContagemPorFuncao(@RequestBody DadosDatas dados){
        var contagemPorFuncao = service.contagemPorFuncao(dados);
        return ResponseEntity.ok(contagemPorFuncao);
    }






}
