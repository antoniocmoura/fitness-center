package com.antoniocmoura.fitness.center.infrastructure.persistence.physical.evaluation;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;
import com.antoniocmoura.fitness.center.domain.entity.student.Student;
import com.antoniocmoura.fitness.center.infrastructure.persistence.student.StudentJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_evaluation")
public class EvaluationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, unique = true)
    private StudentJpaEntity student;

    private LocalDateTime evaluationDate;

    private double weight;

    private double height;

    public static EvaluationJpaEntity fromDomain(final Student student, final Evaluation evaluation) {
        return new EvaluationJpaEntity(
                evaluation.getId(),
                StudentJpaEntity.fromDomain(student),
                evaluation.getEvaluationDate(),
                evaluation.getWeight(),
                evaluation.getHeight()
        );
    }

    public Evaluation toDomain() {
        return Evaluation.newPhysicalEvaluation(
                this.getId(),
                this.getStudent().getId(),
                this.getEvaluationDate(),
                this.getWeight(),
                this.getHeight()
        );
    }

}
