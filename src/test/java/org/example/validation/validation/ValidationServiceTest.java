package org.example.validation.validation;

import lombok.extern.slf4j.Slf4j;
import org.example.validation.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;


@Slf4j
@SpringBootTest()
class ValidationServiceTest {

    @Autowired
    ValidationService validationService;

    @Test
    public void test_sayHi() {
        validationService.sayHi();
    }

    @Test
    public void test_blankThrows() {
        Customer blankId = new Customer();
        ValidationService.ValidationException validationException =
                assertThrows(ValidationService.ValidationException.class,
                        () -> validationService.validate(blankId));

        assertThat(validationException.getMessage(), is(notNullValue()));
        log.info("message when blank id: {}", validationException.getMessage());
        assertThat(validationException.getMessage(),
                is("Customer.id must not be null"));
    }

}