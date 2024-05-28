package com.example.its.web.Validation;

import com.example.its.domain.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.util.proxy.ProxyFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String > {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByUsername(value).isEmpty();
    }
}
