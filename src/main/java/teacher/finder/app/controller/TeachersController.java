package teacher.finder.app.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import teacher.finder.app.teacher.DadosCadastroTeacher;
import teacher.finder.app.teacher.DadosListagemTeacher;
import teacher.finder.app.teacher.Teacher;
import teacher.finder.app.teacher.TeacherRepository;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTeacher dados){
        repository.save(new Teacher(dados));
    }

    @GetMapping
    public Page<DadosListagemTeacher> listTeachers(Pageable pagination){
        return repository.findAll(pagination).map(DadosListagemTeacher::new);
    }

}

