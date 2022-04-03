package com.epam.esm.validator.impl;

import com.epam.esm.exception.NotValidEntityException;
import com.epam.esm.model.User;
import com.epam.esm.validator.api.Validator;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User> {
    private static final String NOT_VALID_USER = "Not valid user";
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 564;

    @Override
    public boolean isValid(User user) {
        String name = user.getName();
        if (name == null) {
            throw new NotValidEntityException(NOT_VALID_USER);
        }
        if (user.getEmail() == null || user.getEmail().length() < NAME_MIN_LENGTH

                || user.getPassword().length() < NAME_MIN_LENGTH) {
            throw new NotValidEntityException(NOT_VALID_USER);
        }
        name = name.trim();
        if (name.length() > NAME_MIN_LENGTH
                && name.length() < NAME_MAX_LENGTH) {
            return true;
        } else {
            throw new NotValidEntityException(NOT_VALID_USER);
        }
    }
}
