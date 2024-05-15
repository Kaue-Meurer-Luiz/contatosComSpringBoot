package br.com.kaue.contatos.controller;

import br.com.kaue.contatos.dto.ContatoCadastroDto;
import br.com.kaue.contatos.dto.ContatoExibicaoDto;
import br.com.kaue.contatos.model.Contato;
import br.com.kaue.contatos.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {


    @Autowired
    private ContatoService service;


    @GetMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoExibicaoDto gravar(@RequestBody @Valid ContatoCadastroDto contatoCadastroDto) {
        return service.gravar(contatoCadastroDto);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodosOsContatos() {
        return service.listarTodosOsContatos();
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(@RequestBody Contato contato) {
        return service.atualizar(contato);
    }

    @GetMapping("/contatos/por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarContatoPeloNome(@PathVariable String nome) {
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoExibicaoDto> listarAniversariantes(
            @PathVariable LocalDate dataInicial,
            @PathVariable LocalDate dataFinal) {
        return service.listarAniversariantesDoPeriodo(dataInicial, dataFinal);
    }
}
