package br.com.kaue.contatos.repository;

import br.com.kaue.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository <Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE c.dataNascimento BETWEEN :dataInicial AND :dataFinal")
    List<Contato> listarAniversariantesDoPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal);



    @Query("SELECT c FROM Contato c WHERE c.nome = :nome")
    Optional<Contato> buscarContatoPeloNome(@Param("nome") String nome);


    Optional<Contato> findByEmail(String email);

}
