package yfzyn.entity.json;

/**
 * Created by xiaoliu(yfzyn) on 12/1/2016.
 */
public class Pet {
    public Pet(){};
    public String getPetName() {
        return petName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petAge=" + petAge +
                '}';
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
    private String petName;
    private Integer petAge;
}
