package teacher.finder.app.teacher;

public record DadosListagemTeacher(String nome, String email, String matricula, Especialidade especialidade) {
    public DadosListagemTeacher(Teacher teacher){
        this(teacher.getNome(), teacher.getEmail(), teacher.getMatricula(), teacher.getEspecialidade());
    }
}
