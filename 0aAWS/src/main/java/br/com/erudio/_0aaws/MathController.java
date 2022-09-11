package br.com.erudio._0aaws;

import br.com.erudio._0aaws.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Plz set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("plz set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/square-root/{number}")

    public Double squareRoot(
            @PathVariable(value = "number") String number
    )throws Exception{
        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("plz iosdoid");
        }
        return Math.sqrt(convertToDouble(number));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
