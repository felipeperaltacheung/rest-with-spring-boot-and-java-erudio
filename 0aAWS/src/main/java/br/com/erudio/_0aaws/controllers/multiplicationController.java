package br.com.erudio._0aaws.controllers;

import br.com.erudio._0aaws.exceptions.UnsupportedMathOperationException;
import br.com.erudio._0aaws.services.operationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class multiplicationController implements operationService {

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")

    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("plz vbdldl");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

}
