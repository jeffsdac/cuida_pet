package br.com.cuidapet.cuidapet.models.funcionario;

import br.com.cuidapet.cuidapet.models.BaseModelClass;
import br.com.cuidapet.cuidapet.models.prestacaoServico.PrestacaoServicoModel;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Table(name = "T_CUIDAPET_FUNCIONARIO")
@Entity
public class FuncionarioModel extends BaseModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String primeiroNome;

    @Column(nullable = false, length = 30)
    private String segundNome;

    @OneToMany( mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestacaoServicoModel> prestacoes;

    // private Image fotoPerfil;
    // TODO: integração com o S3.

}
