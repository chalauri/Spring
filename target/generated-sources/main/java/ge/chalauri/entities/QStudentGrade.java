package ge.chalauri.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentGrade is a Querydsl query type for StudentGrade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentGrade extends EntityPathBase<StudentGrade> {

    private static final long serialVersionUID = -1214666330L;

    public static final QStudentGrade studentGrade = new QStudentGrade("studentGrade");

    public final NumberPath<Double> grade = createNumber("grade", Double.class);

    public final NumberPath<Integer> studentGradeId = createNumber("studentGradeId", Integer.class);

    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);

    public final NumberPath<Integer> subjectId = createNumber("subjectId", Integer.class);

    public QStudentGrade(String variable) {
        super(StudentGrade.class, forVariable(variable));
    }

    public QStudentGrade(Path<? extends StudentGrade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentGrade(PathMetadata metadata) {
        super(StudentGrade.class, metadata);
    }

}

