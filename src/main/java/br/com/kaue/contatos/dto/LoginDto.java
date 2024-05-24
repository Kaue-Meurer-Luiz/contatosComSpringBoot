package br.com.kaue.contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(

        @NotBlank(message = "O e-mail do usuario é obrigatorio!")
        @Email(message = "O e-mail do usuario não é valido!")
        String email,

        @NotBlank(message = "A senha do usuario é obrigatorio!")
        @Size(min = 8, max = 35, message = "A senha deve conter entre 8 e 35 caracteres!")
        String senha
) {
}
