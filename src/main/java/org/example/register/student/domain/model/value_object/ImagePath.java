package org.example.register.student.domain.model.value_object;

import org.example.register.student.domain.exception.DomainException;

public record ImagePath(String imagePath) {
    public ImagePath {
        validateImagePath(imagePath);
    }

    private void validateImagePath(String imagePath) {
        if (emptyValue(imagePath)) {
            throw new DomainException("La ruta de la imagen no puede ser nula");
        }
    }

    private boolean emptyValue(String imagePath) {
        return imagePath == null || imagePath.trim().isEmpty();
    }
}
