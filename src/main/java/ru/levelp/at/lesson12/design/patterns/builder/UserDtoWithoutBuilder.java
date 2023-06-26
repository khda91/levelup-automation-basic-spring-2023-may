package ru.levelp.at.lesson12.design.patterns.builder;

public class UserDtoWithoutBuilder {

    private String name;
    private String email;
    private String password;


    // В Java так делать нельзя, так как уже есть конструктор с такой сигнатурой
    //    public UserDtoWithoutBuilder(String name, String password) {
    //        this.name = name;
    //        this.password = password;
    //    }

    public UserDtoWithoutBuilder(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDtoWithoutBuilder(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDtoWithoutBuilder{"
            + "name='" + name + '\''
            + ", email='" + email + '\''
            + ", password='" + password + '\''
            + '}';
    }
}
