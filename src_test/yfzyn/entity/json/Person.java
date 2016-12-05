package yfzyn.entity.json;

import java.util.List;
import yfzyn.entity.json.Address;

/**
 * Created by xiaoliu(yfzyn) on 12/1/2016.
 */
public class Person {

    private String personName;
    private Boolean personAlive;
    private List<Pet> personsPets;
    private Address personsAddress;

    public Person(){};
    public Person(String personName, Boolean personAlive, List<Pet> personsPets, Address personsAddress) {
        this.personName = personName;
        this.personAlive = personAlive;
        this.personsPets = personsPets;
        this.personsAddress = personsAddress;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public Boolean getPersonAlive() {
        return personAlive;
    }
    public void setPersonAlive(Boolean personAlive) {
        this.personAlive = personAlive;
    }
    public List<Pet> getPersonsPets() {
        return personsPets;
    }
    public void setPersonsPets(List<Pet> personsPets) {
        this.personsPets = personsPets;
    }
    public Address getPersonsAddress() {
        return personsAddress;
    }
    public void setPersonsAddress(Address personsAddress) {
        this.personsAddress = personsAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAlive=" + personAlive +
                ", personsPets=" + personsPets +
                ", personsAddress=" + personsAddress +
                '}';
    }
}
