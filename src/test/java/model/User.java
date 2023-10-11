package model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private Address address;
    private ArrayList<String> phones;

    public User(int userId, String firstName, String lastName, Address address, ArrayList<String> phones) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phones = phones;
    }

    public  User () {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                '}';
    }


    public class Address{
        private String country;
        private String city;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

}
