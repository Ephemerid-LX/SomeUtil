package yfzyn.entity.json;

/**
 * Created by xiaoliu(yfzyn) on 12/1/2016.
 */
public class Pet {
    private String petName;
    private Integer petAge;

    public Pet(){};

    public Pet(String petName, Integer petAge) {
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public Integer getPetAge() {
        return petAge;
    }
    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petAge=" + petAge +
                '}';
    }
}
