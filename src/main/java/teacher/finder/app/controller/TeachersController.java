package teacher.finder.app.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import teacher.finder.app.teacher.*;

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
    public Page<DadosListagemTeacher> listTeachers(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination){
        return repository.findAll(pagination).map(DadosListagemTeacher::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTeacher dados){
        var teacher = repository.getReferenceById(dados.id());
        teacher.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}

