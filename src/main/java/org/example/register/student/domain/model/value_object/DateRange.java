package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

import java.time.LocalDate;

public record DateRange(LocalDate startDate, LocalDate endDate) {
    public DateRange {
        validateDateRange(startDate, endDate);
    }

    private void validateDateRange(LocalDate startDate, LocalDate endDate) {
        if (nullDateRange(startDate, endDate)) {
            throw new DomainException("Las fechas no pueden ser nulas");
        }
        if (validateDateRanges(startDate, endDate)) {
            throw new DomainException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
    }

    private boolean validateDateRanges(LocalDate startDate, LocalDate endDate) {
        return startDate.isAfter(endDate);
    }

    private boolean nullDateRange(LocalDate startDate, LocalDate endDate) {
        return startDate == null || endDate == null;
    }
}