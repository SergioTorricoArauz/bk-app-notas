package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

public record LastName(String lastName) {

    public LastName {
        validateLastName(lastName);
    }

    private void validateLastName(String lastName) {
        if (emptyValue(lastName)) {
            throw new DomainException("El apellido no puede ser nulo");
        }
    }

    private boolean emptyValue(String lastName) {
        return lastName == null || lastName.trim().isEmpty();
    }
}
