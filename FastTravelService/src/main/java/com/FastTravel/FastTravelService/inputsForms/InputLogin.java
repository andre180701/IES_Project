package com.FastTravel.FastTravelService.inputsForms;

public class InputLogin {
    private String email;
    private String password;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "InputLogin [email=" + email + ", password=" + password + "]";
    }
    
}
