package gustavo.elin.api.controller;

import gustavo.elin.api.dto.DadosAtualizacaoTime;
import gustavo.elin.api.dto.DadosCadastroTime;
import gustavo.elin.api.model.Time;
import gustavo.elin.api.dto.DadosListagemTimes;
import gustavo.elin.api.dto.DadosTime;
import gustavo.elin.api.repository.TimeRepository;
import gustavo.elin.api.service.TimeService;
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
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTime dados, UriComponentsBuilder uriBuilder){
        var dto = timeService.cadastrarTime(dados);
        var uri = uriBuilder.path("/times/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10) Pageable paginacao){
        var dto = timeService.listarTime(paginacao);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var dto = timeService.detalharTime(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTime dados){
        var dto = timeService.atualizarTime(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        timeService.excluirTime(id);
        return ResponseEntity.noContent().build();
    }

}
