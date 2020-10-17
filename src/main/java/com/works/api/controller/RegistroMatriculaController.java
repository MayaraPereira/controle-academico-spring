package com.works.api.controller;


import com.works.api.exceptionhandler.ObjectNotFoundException;
import com.works.domain.dto.TurmaReadDTO;
import com.works.domain.model.Aluno;
import com.works.domain.model.RegistroMatricula;
import com.works.domain.model.Turma;
import com.works.domain.repository.AlunoRepository;
import com.works.domain.repository.TurmaRepository;
import com.works.domain.services.AlunoService;
import com.works.domain.services.RegistroDeMatriculaService;
import com.works.domain.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula")
public class RegistroMatriculaController {

    @Autowired
    AlunoService alunoService;

    @Autowired
    TurmaService turmaService;

    @Autowired
    RegistroDeMatriculaService registroDeMatriculaService ;

    @GetMapping
    public List<TurmaReadDTO> listar(){
        try{
            return turmaService.buscarTodos();
        }catch (Exception ex) {
            throw new ObjectNotFoundException("Objetos não encontrados!");
        }

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Turma> adicionar(@Valid @RequestBody RegistroMatricula matricula){
        try{
            return registroDeMatriculaService.adicionar(matricula);

        } catch (Exception ex) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



//    public Turma matricula( RegistroMatricula matricula){
//
//        Turma turma = turmaRepository.getById(matricula.getIdTurma());
//        Aluno aluno = alunoRepository.getAlunos().get(matricula.getIdAluno());
//
//        if(turma == null || aluno == null)
//            return Response.status(Response.Status.NOT_FOUND).build();
//        try {
//            turma.realizarMatricula(aluno.getId());
//            return Response.status(Response.Status.CREATED).build();
//
//        } catch (Exception ex) {
//            return Response
//                    .status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity(ex.getMessage()).build();
//        }
//    }


}


