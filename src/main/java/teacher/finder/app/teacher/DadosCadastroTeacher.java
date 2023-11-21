package teacher.finder.app.teacher;

import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import teacher.finder.app.endereco.DadosEndereco;

public record DadosCadastroTeacher(String nome, String email, String matricula, Especialidade especialide, DadosEndereco endereco) {
}
