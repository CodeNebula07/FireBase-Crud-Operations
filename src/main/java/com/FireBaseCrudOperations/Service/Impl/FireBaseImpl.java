package com.FireBaseCrudOperations.Service.Impl;

import com.FireBaseCrudOperations.Data.FireBaseDto;

import java.util.List;

public interface FireBaseImpl {

    // Retrieves a list of FireBaseDto objects
    List<FireBaseDto> list();

    // Adds a new FireBaseDto object
    String add(FireBaseDto post);

    // Edits an existing FireBaseDto object by name
    String edit(String name, FireBaseDto post);

    // Deletes an existing FireBaseDto object by name
    String delete(String name);
}
