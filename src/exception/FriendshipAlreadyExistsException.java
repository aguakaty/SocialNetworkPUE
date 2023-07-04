package exception;

import model.Person;

// TODO: Enriquecer las excepciones
public class FriendshipAlreadyExistsException extends Exception {
    private Person person1;
    private Person person2;

    public FriendshipAlreadyExistsException(Person person1, Person person2) {
        super("The friendship between "+person1.getName()+" and "+person2.getName()+" is already exists");
        this.person1 = person1;
        this.person2 = person2;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }
}
