package org.example.register.student.domain.model;

import org.example.register.student.domain.model.value_object.*;

public class Student {
    private Long id;
    private Username username;
    private Name name;
    private LastName lastName;
    private Password password;
    private DateBirth dateBirth;
    private DateRange registrationDateRange;
    private ImagePath imagePath;

    public Student() {
    }

    public Student(Long id, Username username, Name name, LastName lastName, Password password, DateBirth dateBirth, DateRange registrationDateRange, ImagePath imagePath) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.dateBirth = dateBirth;
        this.registrationDateRange = registrationDateRange;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public DateBirth getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(DateBirth dateBirth) {
        this.dateBirth = dateBirth;
    }

    public DateRange getRegistrationDateRange() {
        return registrationDateRange;
    }

    public void setRegistrationDateRange(DateRange registrationDateRange) {
        this.registrationDateRange = registrationDateRange;
    }

    public ImagePath getImagePath() {
        return imagePath;
    }

    public void setImagePath(ImagePath imagePath) {
        this.imagePath = imagePath;
    }
}
