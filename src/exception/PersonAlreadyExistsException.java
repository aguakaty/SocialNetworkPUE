package exception;

import model.Person;

public class PersonAlreadyExistsException extends Exception {
    private Person person;

    public PersonAlreadyExistsException(Person person) {
        super("Person "+person.getName()+" already exists");
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
