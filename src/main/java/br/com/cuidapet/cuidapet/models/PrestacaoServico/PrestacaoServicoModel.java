package br.com.cuidapet.cuidapet.models.PrestacaoServico;

import br.com.cuidapet.cuidapet.models.BaseModelClass;
import br.com.cuidapet.cuidapet.models.Pet.PetModel;
import br.com.cuidapet.cuidapet.models.Usuario.UsuarioModel;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "T_CUIDAPET_PRESTACAOSERVICO")
public class PrestacaoServicoModel extends BaseModelClass {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, precision = 8)
    private Long valorDoServico;

    @Column(nullable = false)
    private Instant dataInicio;

    @Column(nullable = false)
    private Instant dataFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetModel pet;


    private String status;
    // TODO: enum

}
