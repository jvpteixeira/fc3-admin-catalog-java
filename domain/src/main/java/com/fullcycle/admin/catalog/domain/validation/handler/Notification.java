package com.fullcycle.admin.catalog.domain.validation.handler;

import com.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fullcycle.admin.catalog.domain.validation.Error;
import com.fullcycle.admin.catalog.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<Error> errors;

    public Notification(final List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create(final Throwable t){
        return create(new Error(t.getMessage()));
    }

    public static Notification create(){
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Error anError){
        return new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public Notification append(Error anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public Notification append(ValidationHandler anHandler) {
        this.errors.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(Validation<T> aValidation) {
        try{
            aValidation.validate();
        } catch(final DomainException ex){
            this.errors.addAll(ex.getErrors());
        } catch(final Throwable t){
            this.errors.add(new Error(t.getMessage()));
        }

        return null;
    }

    @Override
    public List<Error> getErrors() {
        return this.errors;
    }
}
