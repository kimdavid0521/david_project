package com.example.soloProject.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable  //다른 클래스에 임베디드 될 수 있음
@Getter
public class Address {

    private String city;

    private String street;

    private String zipcode;

    protected Address() { //JPA는 기본 생성자가 필요함, 객체를 생성할때 필요, protect로 선언하여 외부에서는 기본 생성자 사용못하게 함.
    }

    public Address(String city, String street, String zipcode) { //address객체를 생성할때 사용됨,
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
