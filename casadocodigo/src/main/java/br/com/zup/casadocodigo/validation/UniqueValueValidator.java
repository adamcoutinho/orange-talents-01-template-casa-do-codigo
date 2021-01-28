package br.com.zup.casadocodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {

    @PersistenceContext
    private EntityManager manager;
    private Class<?> kclass;
    private String domainAttribute;
    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.kclass = constraintAnnotation.domainClass();
        this.domainAttribute = constraintAnnotation.fieldName();

    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Query query = this.manager.createQuery("SELECT 1 FROM "+this.kclass.getName()+" WHERE "+this.domainAttribute+" = :value");

        query.setParameter("value",value);

        List<?> list = query.getResultList();

        return list.isEmpty();
    }


}
