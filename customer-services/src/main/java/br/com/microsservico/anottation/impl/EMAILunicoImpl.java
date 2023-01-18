package br.com.microsservico.anottation.impl;

import br.com.microsservico.anottation.EMAILunico;
import br.com.microsservico.service.impl.CustomerServiceImpl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EMAILunicoImpl implements ConstraintValidator<EMAILunico, String> {

    @Inject
    private CustomerServiceImpl customerService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return customerService.findByEmail(email).list().isEmpty();
    }
}
