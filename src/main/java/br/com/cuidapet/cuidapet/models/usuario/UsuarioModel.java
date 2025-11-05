package br.com.cuidapet.cuidapet.models.usuario;

import br.com.cuidapet.cuidapet.models.BaseModelClass;
import br.com.cuidapet.cuidapet.models.prestacaoServico.PrestacaoServicoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name="T_CUIDAPET_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioModel extends BaseModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String primeiroNome;

    @Column(nullable = false, length = 30)
    private String ultimoNome;

    @Column(length = 11)
    private String cpf;

    @Column(nullable = false, length = 350)
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestacaoServicoModel> prestacoes = new ArrayList<>();
    // private String password;
    // Implementar com springSecurity depois;

}
