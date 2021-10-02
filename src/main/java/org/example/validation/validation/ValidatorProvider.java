package org.example.validation.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.springframework.stereotype.Component;


@Component
public class ValidatorProvider {

    private final Validator validator;

    public ValidatorProvider() {
        // https://stackoverflow.com/a/54750045
        validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
    }

    public Validator getValidator() {
        return validator;
    }
}
