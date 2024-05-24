package br.com.kaue.contatos.controller;

import br.com.kaue.contatos.config.security.TokenService;
import br.com.kaue.contatos.dto.LoginDto;
import br.com.kaue.contatos.dto.TokenDto;
import br.com.kaue.contatos.dto.UsuarioCadastroDto;
import br.com.kaue.contatos.dto.UsuarioExibicaoDto;
import br.com.kaue.contatos.model.Usuario;
import br.com.kaue.contatos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.senha());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token));
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        UsuarioExibicaoDto usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(usuarioCadastroDto);
        return usuarioSalvo;

    }
}
