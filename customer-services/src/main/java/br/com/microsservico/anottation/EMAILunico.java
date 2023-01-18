package br.com.microsservico.anottation;


import br.com.microsservico.anottation.impl.EMAILunicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = EMAILunicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EMAILunico {

    String message() default "Já existe um Usuário cadastrado com o EMAIL informado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
