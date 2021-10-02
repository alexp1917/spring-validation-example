package org.example.validation.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Component
public class ValidationService {

    private final String hiValue;
    private final Validator validator;

    public ValidationService(@Value("${example.validation.hi}") String hiValue,
                             ValidatorProvider validatorProvider) {
        this.hiValue = hiValue;
        this.validator = validatorProvider.getValidator();
    }

    // put this here to test that my spring setup was working right
    public void sayHi() {
        log.info(hiValue);
    }

    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> validate = validator.validate(object);
        List<String> messages = validate.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        if (messages.isEmpty())
            return;
        throw new ValidationException(String.join(", ", messages));
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

}
