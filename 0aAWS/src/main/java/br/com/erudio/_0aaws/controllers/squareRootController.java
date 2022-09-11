package br.com.erudio._0aaws.controllers;

import br.com.erudio._0aaws.exceptions.UnsupportedMathOperationException;
import br.com.erudio._0aaws.services.operationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class squareRootController implements operationService {

    @RequestMapping(value = "/square-root/{number}")

    public Double squareRoot(
            @PathVariable(value = "number") String number
    )throws Exception{
        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("plz iosdoid");
        }
        return Math.sqrt(convertToDouble(number));
    }

}
