package br.com.kaue.contatos.dto;

import br.com.kaue.contatos.model.Usuario;
import br.com.kaue.contatos.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario){
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }

}
