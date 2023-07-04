package exception;

import model.Person;

public class PersonNotExistException extends Exception {
    private Person person;

    public PersonNotExistException(Person person) {
        super("Person "+person.getName()+" does not exist");
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }
}
