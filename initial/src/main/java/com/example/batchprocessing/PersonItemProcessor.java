package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        final String fisrtName = person.firstName();
        final String lastName = person.lastName();

        final Person transformedPerson = new Person(fisrtName.toUpperCase(), lastName.toUpperCase());

        log.info("Converting ("+ person + ") into ("+ transformedPerson + ")");

        return transformedPerson;
    }
}
