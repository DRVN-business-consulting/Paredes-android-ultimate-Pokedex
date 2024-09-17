package dev.joely.pokemonapi.dto;

public class SignUpRequest {
    private String username;
    private String name;
    private String password;
    private int age;
    private String address;

    public SignUpRequest(String username, String name, String password, int age, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
