package fr.formation.developers.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {IsAdultValidator.class})

public @interface IsAdult {
    String message () default "Doit être majuscule";
    Class<?> [] groups () default {};
    Class<? extends Payload>[] payload() default {};
}
