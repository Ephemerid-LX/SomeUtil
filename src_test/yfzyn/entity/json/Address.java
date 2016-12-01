package yfzyn.entity.json;

/**
 * Created by xiaoliu(yfzyn) on 12/1/2016.
 */
public class Address {
    public Address(){};
    public String getAddressIp() {
        return addressIp;
    }
    public void setAddressIp(String addressIp) {
        this.addressIp = addressIp;
    }
    public Long getAddressNumber() {
        return addressNumber;
    }
    public void setAddressNumber(Long addressNumber) {
        this.addressNumber = addressNumber;
    }
    private String addressIp;
    private Long addressNumber;

    @Override
    public String toString() {
        return "Address{" +
                "addressIp='" + addressIp + '\'' +
                ", addressNumber=" + addressNumber +
                '}';
    }
}
