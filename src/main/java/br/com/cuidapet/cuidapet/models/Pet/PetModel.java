package br.com.cuidapet.cuidapet.models.Pet;

import br.com.cuidapet.cuidapet.models.BaseModelClass;
import br.com.cuidapet.cuidapet.models.PrestacaoServico.PrestacaoServicoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_CUIDAPET_PET")
@NoArgsConstructor
@AllArgsConstructor
public class PetModel extends BaseModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String primeiroNome;

    @Column(length = 30)
    private String ultimoNome;

    private Instant dataDeNascimento;

    @Column(length = 500)
    private String observacoes;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestacaoServicoModel> prestacoes;

    @Column(nullable = false, length = 25)
    private String tipo;
    // TODO: ENUM??

    // private Porte porte;
    // TODO: Enum

    // private Temperamento temperamento;
    // Todo: ENUM

    // private Images fotoDoPet;
    // TODO: incrementar com S3.
}
