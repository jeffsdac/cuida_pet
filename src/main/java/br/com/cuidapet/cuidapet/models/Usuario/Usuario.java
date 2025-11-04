package br.com.cuidapet.cuidapet.models.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="T_CUIDAPET_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends BaseModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String primeiro_nome;

    @Column(nullable = false, length = 30)
    private String ultimo_nome;

    @Column(length = 11)
    private String cpf;

    @Column(nullable = false, length = 350)
    private String email;


    // private String password;
    // Implementar com springSecurity depois;

}
