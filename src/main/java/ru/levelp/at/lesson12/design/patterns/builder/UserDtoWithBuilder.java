package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;

public class UserDtoWithBuilder {

    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;

    public UserDtoWithBuilder(String name, String email, String password, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserDtoWithBuilder{"
            + "name='" + name + '\''
            + ", email='" + email + '\''
            + ", password='" + password + '\''
            + ", dateOfBirth=" + dateOfBirth
            + '}';
    }

    public static class Builder {

        private String name;
        private String email;
        private String password;
        private LocalDate dateOfBirth;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserDtoWithBuilder build() {
            return new UserDtoWithBuilder(name, email, password, dateOfBirth);
        }
    }
}
