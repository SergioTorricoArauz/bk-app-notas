package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

public record Name(String name) {
    public Name {
        validateName(name);
    }

    private void validateName(String name) {
        if (emptyValue(name)) {
            throw new DomainException("El nombre no puede ser nulo ni vacío");
        }
    }

    private boolean emptyValue(String name) {
        return name == null || name.trim().isEmpty();
    }
}
