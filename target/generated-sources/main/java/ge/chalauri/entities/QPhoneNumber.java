package ge.chalauri.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPhoneNumber is a Querydsl query type for PhoneNumber
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPhoneNumber extends EntityPathBase<PhoneNumber> {

    private static final long serialVersionUID = -260998707L;

    public static final QPhoneNumber phoneNumber = new QPhoneNumber("phoneNumber");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath number = createString("number");

    public final NumberPath<Integer> personId = createNumber("personId", Integer.class);

    public QPhoneNumber(String variable) {
        super(PhoneNumber.class, forVariable(variable));
    }

    public QPhoneNumber(Path<? extends PhoneNumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhoneNumber(PathMetadata metadata) {
        super(PhoneNumber.class, metadata);
    }

}

