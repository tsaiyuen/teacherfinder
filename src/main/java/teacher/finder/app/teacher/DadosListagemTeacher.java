package teacher.finder.app.teacher;

public record DadosListagemTeacher(Long id, String nome, String email, String matricula, Especialidade especialidade) {
    public DadosListagemTeacher(Teacher teacher){
        this(teacher.getId(), teacher.getNome(), teacher.getEmail(), teacher.getMatricula(), teacher.getEspecialidade());
    }
}
