package br.com.cuidapet.cuidapet.service;

import br.com.cuidapet.cuidapet.exceptions.UsuarioNaoEncontrado;
import br.com.cuidapet.cuidapet.models.usuario.UsuarioModel;
import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioCreateDTO;
import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioUpdateDTO;
import br.com.cuidapet.cuidapet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioModel createUser (UsuarioCreateDTO dto) {
        return usuarioRepository.save(UsuarioModel.builder()
                .primeiroNome(dto.primeiroNome())
                .ultimoNome(dto.ultimoNome())
                .cpf(dto.cpf())
                .email(dto.email())
                .build());

    }

    public UsuarioModel findById (UUID id){
        return usuarioRepository.findById(id)
                .orElseThrow( () -> new UsuarioNaoEncontrado(id));

    }

    public UsuarioModel updateUsuario (UUID id, UsuarioUpdateDTO dto){
        var userModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontrado(id));

        userModel.setEmail(dto.email());
        userModel.setPrimeiroNome(dto.primeiroNome());
        userModel.setUltimoNome(dto.ultimoNome());

        return usuarioRepository.save(userModel);
    }


}
