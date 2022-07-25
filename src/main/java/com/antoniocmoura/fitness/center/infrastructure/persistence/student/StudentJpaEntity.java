package com.antoniocmoura.fitness.center.infrastructure.persistence.student;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;
import com.antoniocmoura.fitness.center.infrastructure.persistence.physical.evaluation.EvaluationJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_student")
public class StudentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    @CPF(message = "'${validatedValue}' is invalid!")
    private String cpf;

    private String address;

    private LocalDate birthDate;

    private Boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // @JsonIgnore
    private List<EvaluationJpaEntity> evaluations;

    public static StudentJpaEntity fromDomain(Student student) {
        return new StudentJpaEntity(
                student.getId(),
                student.getName(),
                student.getCpf(),
                student.getAddress(),
                student.getBirthDate(),
                student.getActive(),
                student.getCreatedAt(),
                student.getUpdatedAt(),
                student.getEvaluations()
                        .stream()
                        .map(element -> EvaluationJpaEntity.fromDomain(student, element) )
                        .toList()
        );
    }

    public Student toDomain() {
        return Student.newStudent(
                this.getId(),
                this.getName(),
                this.getCpf(),
                this.getAddress(),
                this.getBirthDate(),
                this.getActive(),
                this.getCreatedAt(),
                this.getUpdatedAt(),
                this.evaluations.stream()
                        .map(element -> element.toDomain())
                        .collect(Collectors.toList()));
    }

}
