package com.example.recyclerview;

public class Restaurant {
    private String name;
    private String urlPhoto;
    private Float valoration;
    private String address;

    public Restaurant(String name, String urlPhoto, Float valoration, String address) {
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.valoration = valoration;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Float getValoration() {
        return valoration;
    }

    public void setValoracion(Float valoration) {
        this.valoration = valoration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
