package org.example.validation.validation;

import lombok.extern.slf4j.Slf4j;
import org.example.validation.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.validation.Validator;


@Slf4j
@SpringBootTest(/*classes = Application.class*/)
// @ExtendWith(SpringExtension.class)
class ValidationServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired(required = false)
    Validator defaultValidator;

    @Autowired
    ValidationService validationService;

    @Test
    public void test_sayHi() {
        validationService.sayHi();
    }

    @Test
    public void test() {
        System.out.println(defaultValidator);

        try {
            Validator bean = applicationContext.getAutowireCapableBeanFactory()
                    .getBean(Validator.class);
            log.debug("bean {}", bean);
        } catch (BeansException | IllegalStateException e) {
            e.printStackTrace();
        }

    }

}