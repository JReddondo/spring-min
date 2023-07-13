package com.example.demo.common.middelwares.validator;

import an.awesome.pipelinr.Command;
import br.com.fluentvalidator.AbstractValidator;


import java.util.stream.Collectors;

public abstract class AbstractCommandValidator<C extends Command<R>, R> extends AbstractValidator<C> implements CommandValidator<C , R> {

    @Override
    public void validateCommand(C command) {
        var validationResult = validate(command);
        if( !validationResult.isValid() ){
            var errors = validationResult.getErrors().stream().map(v -> new ErrorReponseValidator(
                    v.getMessage(),
                    v.getField(),
                    v.getAttemptedValue(),
                    v.getCode())).collect(Collectors.toList());

            throw new BadRequestException(errors);
        }
    }
}
