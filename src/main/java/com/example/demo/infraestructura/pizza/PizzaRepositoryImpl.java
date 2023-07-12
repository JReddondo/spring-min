package com.example.demo.infraestructura.pizza;

import com.example.demo.common.Agregate;
import com.example.demo.domain.pizza.PizzaRepository;
import com.example.demo.domain.pizza.entities.Pizza;
import com.example.demo.domain.pizza.entities.Pizza.PizzaId;

import an.awesome.pipelinr.Pipeline;

public class PizzaRepositoryImpl implements PizzaRepository {

    private final Pipeline pipeline;
    public PizzaRepositoryImpl(Pipeline pipeline){
        this.pipeline = pipeline;
    }
    @Override
    public void add(Pizza entity) {
        if(entity instanceof Agregate a){           
            a.getEvents().forEach(e->pipeline.send(e));
            a.clearEvents();
        }
        //guardar entidad en bb.dd        
    }

    @Override
    public void update(Pizza entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Pizza get(PizzaId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void remove(Pizza entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
