package gustavo.elin.api.controller;

import gustavo.elin.api.dto.DadosAtualizacaoIntegrantes;
import gustavo.elin.api.dto.DadosCadastroIntegrantes;
import gustavo.elin.api.dto.DadosIntegrante;
import gustavo.elin.api.dto.DadosListagemIntegrantes;
import gustavo.elin.api.repository.IntegranteRepository;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.service.IntegranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("integrante")
public class IntegranteController {

    @Autowired
    private IntegranteService integranteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroIntegrantes dados, UriComponentsBuilder uriBuilder){
        var dto = integranteService.cadastrarIntegrante(dados);
        var uri = uriBuilder.path("/integrantes/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10) Pageable paginacao){
        var dto = integranteService.listarIntegrante(paginacao);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var dto = integranteService.detalharIntegrante(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoIntegrantes dados){
        var dto = integranteService.atualizarIntegrante(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        integranteService.excluirIntegrante(id);
        return ResponseEntity.noContent().build();
    }

}
