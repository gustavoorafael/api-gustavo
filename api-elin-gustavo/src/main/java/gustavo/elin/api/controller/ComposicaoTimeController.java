package gustavo.elin.api.controller;

import gustavo.elin.api.dto.DadosCadastroComposicao;
import gustavo.elin.api.repository.ComposicaoRepository;
import gustavo.elin.api.dto.DadosComposicao;
import gustavo.elin.api.dto.DadosListagemComposicao;
import gustavo.elin.api.model.ComposicaoTime;
import gustavo.elin.api.service.ComposicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("composicao")
public class ComposicaoTimeController {

    @Autowired
    private ComposicaoService composicaoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroComposicao dados){
        var cadastrar = composicaoService.cadastrarComposicao(dados);
        return ResponseEntity.ok(cadastrar);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10) Pageable paginacao){
        var listar = composicaoService.listarComposicao(paginacao);
        return ResponseEntity.ok(listar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        composicaoService.excluirComposicao(id);
        return ResponseEntity.noContent().build();
    }
}