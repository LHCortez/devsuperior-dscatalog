package com.devsuperior.dscatalog.exceptions;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3186776649084803811L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
