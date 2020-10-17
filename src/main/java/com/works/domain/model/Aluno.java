package com.works.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;


@Entity
@Getter
@Setter
@Table(name="aluno", uniqueConstraints = {})
@SecondaryTable(name = "turma", pkJoinColumns =
        { @PrimaryKeyJoinColumn(name = "id") })
public class Aluno implements Serializable {

    private static final long serialVersionUID = -9109414221418128481L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    private String curso;

    @NotBlank
    private String usuario;

    @NotBlank
    private String senha;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="aluno_has_turma",
            joinColumns={@JoinColumn(name="aluno_id")},
            inverseJoinColumns={@JoinColumn(name="turma_id")})
    private List<Turma> turmas = new ArrayList<>();

    public void setSenha(String senha) {
        String salt = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";
        senha = BCrypt.hashpw(senha, salt);
        this.senha = senha;
    }
    @ManyToMany
    @JoinTable(name="aluno_has_turma",
            joinColumns=
            @JoinColumn(name="id", referencedColumnName="aluno_id"),
            inverseJoinColumns=
            @JoinColumn(name="id", referencedColumnName="turma_id")
    )
    public List<Turma> getTurmas() {
        return turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
