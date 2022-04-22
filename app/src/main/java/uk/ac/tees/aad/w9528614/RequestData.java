package uk.ac.tees.aad.w9528614;

public class RequestData { // string variable for
    // storing employee name.
    private String PhoneNumber;
  private String Address;

    private String  RequestType;

    private String SubRequestType;

    public RequestData() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }
    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        this.RequestType = requestType;
    } public String getSubRequestType() {
        return SubRequestType;
    }

    public void setSubRequestType(String subRequestType) {
        this.SubRequestType = subRequestType;
    }


}