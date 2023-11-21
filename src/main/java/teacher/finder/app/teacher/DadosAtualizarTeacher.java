package teacher.finder.app.teacher;

import jakarta.validation.constraints.NotNull;
import teacher.finder.app.endereco.DadosEndereco;

public record DadosAtualizarTeacher(

        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {
}
