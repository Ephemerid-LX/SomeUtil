package yfzyn.entity.json;

/**
 * Created by xiaoliu(yfzyn) on 12/1/2016.
 */
public class Address {

    private String addressIp;
    private Long addressNumber;

    public Address(){};
    public Address(String addressIp, Long addressNumber) {
        this.addressIp = addressIp;
        this.addressNumber = addressNumber;
    }

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

    @Override
    public String toString() {
        return "Address{" +
                "addressIp='" + addressIp + '\'' +
                ", addressNumber=" + addressNumber +
                '}';
    }
}
