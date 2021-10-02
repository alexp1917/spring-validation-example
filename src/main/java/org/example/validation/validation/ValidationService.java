package org.example.validation.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ValidationService {

    private final String hiValue;

    public ValidationService(@Value("${example.validation.hi}") String hiValue) {
        this.hiValue = hiValue;
    }

    public void sayHi() {
        log.info(hiValue);
    }

}
