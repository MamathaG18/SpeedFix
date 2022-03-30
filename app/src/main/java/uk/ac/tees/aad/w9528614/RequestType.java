package uk.ac.tees.aad.w9528614;

import java.io.Serializable;
import java.util.List;

public class RequestType  implements Serializable {


    private String request;

    // private List<Brands> brands = null;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
/*
    public List<Brands> getBrands() {
        return brands;
    }

    public void setBrands(List<Brands> brands) {
        this.brands = brands;
    }*/
}
