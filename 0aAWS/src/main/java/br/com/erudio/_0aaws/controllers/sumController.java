package br.com.erudio._0aaws.controllers;

import br.com.erudio._0aaws.exceptions.UnsupportedMathOperationException;
import br.com.erudio._0aaws.services.operationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class sumController implements operationService {

    private  final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Plz set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
}

