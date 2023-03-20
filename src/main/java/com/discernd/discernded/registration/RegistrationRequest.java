package com.discernd.discernded.registration;

import java.util.Objects;

public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String identityNumber;
    private final String email;
    private final String password;

    public RegistrationRequest(String firstName, String lastName, String identityNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", identityNumber='" + identityNumber + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identityNumber, that.identityNumber) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, identityNumber, email, password);
    }
}
