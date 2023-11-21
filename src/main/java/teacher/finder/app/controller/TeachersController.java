package teacher.finder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teacher.finder.app.teacher.DadosCadastroTeacher;
import teacher.finder.app.teacher.Teacher;
import teacher.finder.app.teacher.TeacherRepository;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroTeacher dados){
        repository.save(new Teacher(dados));
    }

}

