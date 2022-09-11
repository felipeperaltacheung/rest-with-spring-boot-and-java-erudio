package br.com.erudio._0aaws.controllers;

import br.com.erudio._0aaws.exceptions.UnsupportedMathOperationException;
import br.com.erudio._0aaws.services.operationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class averageController implements operationService {

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}")

    public Double average(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("plz blabla");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberOne)) / 2;
    }

}
