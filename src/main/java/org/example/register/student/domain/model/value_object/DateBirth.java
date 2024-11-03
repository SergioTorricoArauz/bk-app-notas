package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

import java.time.LocalDate;

public record DateBirth(LocalDate birthDate) {
    public DateBirth {
        validateDateBirth(birthDate);
    }

    private void validateDateBirth(LocalDate birthDate) {
        if (nullValue(birthDate)) {
            throw new DomainException("La fecha de nacimiento no puede ser nula");
        }
        if (birthDate.isAfter(LocalDate.now())) {
            throw new DomainException("La fecha de nacimiento no puede ser posterior a la fecha actual");
        }
    }

    private boolean nullValue(LocalDate birthDate) {
        return birthDate == null;
    }
}