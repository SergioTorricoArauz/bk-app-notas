package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

public record Password(String password) {
    public Password {
        validatePassword(password);
    }

    private void validatePassword(String password) {
        if (isEmpty(password)) {
            throw new DomainException("La contraseña no puede ser nula o vacía");
        }
        if (!hasValidLength(password)) {
            throw new DomainException("La contraseña debe tener al menos 8 caracteres");
        }
        if (!hasLowerCase(password)) {
            throw new DomainException("La contraseña debe tener al menos una letra minúscula");
        }
        if (!hasNumber(password)) {
            throw new DomainException("La contraseña debe tener al menos un número");
        }
    }

    private boolean isEmpty(String password) {
        return password == null || password.trim().isEmpty();
    }

    private boolean hasValidLength(String password) {
        return password.length() >= 8;
    }

    private boolean hasLowerCase(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    private boolean hasNumber(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }
}
