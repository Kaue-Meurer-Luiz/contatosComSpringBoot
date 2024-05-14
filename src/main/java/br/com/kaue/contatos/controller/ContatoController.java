package br.com.kaue.contatos.controller;

import br.com.kaue.contatos.model.Contato;
import br.com.kaue.contatos.service.ContatoService;
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


    @PostMapping("contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato gravar (@RequestBody Contato contato){
        return service.gravar(contato);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodosOsContatos(){
        return service.listarTodosOsContatos();
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }


    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(@RequestBody Contato contato){
        return service.atualizar(contato);
    }

    @GetMapping("/contatos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarContatoPeloNome(@PathVariable String nome){
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
        public List<Contato> mostrarAniversariantes(@PathVariable LocalDate dataInicial,
                                                    @PathVariable LocalDate dataFinal){
            return service.mostrarAniversariantes(dataInicial, dataFinal);
        }
}
