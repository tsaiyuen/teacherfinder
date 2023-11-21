package teacher.finder.app.teacher;

import jakarta.persistence.*;
import lombok.*;
import teacher.finder.app.endereco.DadosEndereco;
import teacher.finder.app.endereco.Endereco;

@Table(name = "teachers")
@Entity(name = "Teacher")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String matricula;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Teacher(DadosCadastroTeacher dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.matricula = dados.matricula();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
