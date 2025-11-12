package br.com.cuidapet.cuidapet.controllers;

import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioCreateDTO;
import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioLoginDTO;
import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioSenderDTO;
import br.com.cuidapet.cuidapet.models.usuario.dtos.UsuarioUpdateDTO;
import br.com.cuidapet.cuidapet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioSenderDTO> createUser (@RequestBody UsuarioCreateDTO dto) {
        var modelUser = usuarioService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body( new UsuarioSenderDTO(modelUser.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSenderDTO> findById (@PathVariable UUID id){
        var modelUser = usuarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioSenderDTO(modelUser.getEmail()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSenderDTO> updateById (@PathVariable UUID id, @RequestBody UsuarioUpdateDTO dto){
        var modelUser = usuarioService.updateUsuario(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body( new UsuarioSenderDTO(modelUser.getEmail()) );
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioSenderDTO> loginByEmail(@RequestBody UsuarioLoginDTO dto){
        var modelUser = usuarioService.findByEmail(dto.email());
        return ResponseEntity.status(HttpStatus.OK).body( new UsuarioSenderDTO(modelUser.getEmail()) );
    }



}
