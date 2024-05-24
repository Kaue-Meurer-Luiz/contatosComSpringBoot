package br.com.kaue.contatos.service;

import br.com.kaue.contatos.dto.UsuarioCadastroDto;
import br.com.kaue.contatos.dto.UsuarioExibicaoDto;
import br.com.kaue.contatos.exception.UsuarioNaoEncontradoException;
import br.com.kaue.contatos.model.Usuario;
import br.com.kaue.contatos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioDTO){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    public UsuarioExibicaoDto buscarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrato no Banco de dados!");
        }
    }


}
