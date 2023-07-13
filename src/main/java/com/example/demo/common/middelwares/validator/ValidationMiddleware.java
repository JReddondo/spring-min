package com.example.demo.common.middelwares.validator;

import an.awesome.pipelinr.Command;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@SuppressWarnings("all")
public class ValidationMiddleware implements Command.Middleware {
        private final ObjectProvider<CommandValidator> validators; // requires Spring 5+. For older versions, use BeanFactory.

        ValidationMiddleware(ObjectProvider<CommandValidator> validators) {
            this.validators = validators;
        }

        @Override
        public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
            
            validators.stream()
                    .filter(v -> v.matches(command))
                    .findFirst()
                    .ifPresent(v -> v.validateCommand(command));

            return next.invoke();
        }
}

