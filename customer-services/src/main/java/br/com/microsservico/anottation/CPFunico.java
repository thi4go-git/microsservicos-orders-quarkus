package br.com.microsservico.anottation;

import br.com.microsservico.anottation.impl.CPFunicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = CPFunicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFunico {

    String message() default "Já existe um Usuário cadastrado com o CPF informado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
