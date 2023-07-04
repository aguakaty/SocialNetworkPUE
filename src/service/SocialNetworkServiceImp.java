package service;

import exception.FriendshipAlreadyExistsException;
import exception.PersonAlreadyExistsException;
import exception.PersonNotExistException;
import exception.PersonSubclassNotExistException;
import jakarta.validation.constraints.NotNull;
import model.Person;

import java.io.FileNotFoundException;
import java.util.*;

public class SocialNetworkServiceImp implements SocialNetworkService{

    //private Person[][] people = new Person[10][10];
    private Map<Person, Set<Person>> friendships = new LinkedHashMap<>();

    @Override
    public void addPerson(@NotNull Person person) throws PersonAlreadyExistsException {
        //TODO: Crear una logica de que si el Person es free o el Premium (si es premium - esta illimitado)
        if (friendships.containsKey(person)){
            throw new PersonAlreadyExistsException(person);
        }
        friendships.put(person, new LinkedHashSet<>());

    }

    @Override
    public Set<Person> getPeople() {
        return Collections.unmodifiableSet(friendships.keySet());
    }

    @Override
    public void addFriendship(@NotNull Person p1, @NotNull Person p2)
            throws PersonNotExistException, FriendshipAlreadyExistsException, PersonSubclassNotExistException{
        //TODO: Hacer un throws de una excepcion mas generica
        if(!friendships.containsKey(p1)){
            throw new PersonSubclassNotExistException(p1);
        }
        if(!friendships.containsKey(p2)){
            throw new PersonNotExistException(p2);
        }
        var friends1 = friendships.get(p1);
        var friends2 = friendships.get(p2);
        if(friends1.contains(p2)){
            throw new FriendshipAlreadyExistsException(p1,p2);
        }
        friends1.add(p2);
        friends2.add(p1);

    }

    @Override
    public Set<Person> getFriends(@NotNull Person person) {
        return Collections.unmodifiableSet(friendships.get(person));
    }

    @Override
    public List<Person> getMinimumPath(Person src, Person dst) {
        return null;
    }
}
