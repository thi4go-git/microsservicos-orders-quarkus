package br.com.microsservico.anottation.impl;


import br.com.microsservico.anottation.CPFunico;
import br.com.microsservico.service.impl.CustomerServiceImpl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFunicoImpl implements ConstraintValidator<CPFunico, String> {

    @Inject
    private CustomerServiceImpl customerService;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return customerService.findByCpf(cpf).list().isEmpty();
    }
}
