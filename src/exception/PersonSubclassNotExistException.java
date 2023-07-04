package exception;

import model.Person;

public class PersonSubclassNotExistException extends PersonNotExistException{
    public PersonSubclassNotExistException(Person person) {
        super(person);
    }
}
