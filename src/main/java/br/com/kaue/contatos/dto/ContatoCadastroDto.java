package br.com.kaue.contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContatoCadastroDto(
        Long id,
        @NotBlank(message = "Nome do contato é obrigatório!")
        String nome,

        @NotBlank(message = "Email é obrigatório!")
        @Email (message = "O E-mail está com o formato inválido!")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 8, max = 25, message = "A senha deve conter entre 8 e 25 caracteres.")
        String senha,



        @NotNull(message = "A data de nascimento é obrigatória!")
        LocalDate dataNascimento
) {
}
