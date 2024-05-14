package br.com.kaue.contatos.service;


import br.com.kaue.contatos.dto.ContatoCadastroDto;
import br.com.kaue.contatos.dto.ContatoExibicaoDto;
import br.com.kaue.contatos.model.Contato;
import br.com.kaue.contatos.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoExibicaoDto gravar(ContatoCadastroDto contatoCadastroDto){
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoCadastroDto, contato);
        return new ContatoExibicaoDto(contatoRepository.save(contato));
    }

    public ContatoExibicaoDto buscarPorId(Long id){

        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if(contatoOptional.isPresent()){
            return new ContatoExibicaoDto(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }


    public List<Contato> listarTodosOsContatos(){
        return contatoRepository.findAll();
    }

    public void excluir(Long id){
        Optional <Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            contatoRepository.delete(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado !");
        }
    }


    public List<Contato> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return contatoRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    public Contato atualizar(Contato contato){
        Optional <Contato> contatoOptional = contatoRepository.findById(contato.getId());

        if (contatoOptional.isPresent()){
            return contatoRepository.save(contato);
        } else {
            throw new RuntimeException("Contato não encontrado !");
        }
    }

    public Contato buscarPeloNome(String nome){
        Optional<Contato> contatoOptional = contatoRepository.findByNome(nome);

        if (contatoOptional.isPresent()){
            return contatoOptional.get();
        } else {
            throw new RuntimeException("Contato não encontrado!");
        }

    }



}
