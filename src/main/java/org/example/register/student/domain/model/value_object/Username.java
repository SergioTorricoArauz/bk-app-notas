package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

public record Username(String username) {
    public Username {
        validateUsername(username);
    }

    private void validateUsername(String username) {
        if (isEmpty(username)) {
            throw new DomainException("El nombre de usuario no puede ser nulo o vacío");
        }
        if (!isValidLength(username)) {
            throw new DomainException("El nombre de usuario debe tener entre 3 y 20 caracteres");
        }
        if (!isValidFormat(username)) {
            throw new DomainException("El nombre de usuario solo puede contener letras, números y guiones bajos");
        }
    }

    private boolean isEmpty(String username) {
        return username == null || username.trim().isEmpty();
    }

    private boolean isValidLength(String username) {
        int length = username.length();
        return length >= 3 && length <= 20;
    }

    private boolean isValidFormat(String username) {
        return username.matches("^[a-zA-Z0-9_]+$");
    }
}
