package br.com.rodilon.rest_with_spring_boot_and_java.controller;

import br.com.rodilon.rest_with_spring_boot_and_java.exceptions.CalcException;
import br.com.rodilon.rest_with_spring_boot_and_java.service.CalcService;
import br.com.rodilon.rest_with_spring_boot_and_java.utils.CalcUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private final CalcUtils calcUtils = new CalcUtils();
    private final CalcException calcException = new CalcException(calcUtils);
    CalcService service = new CalcService(calcUtils, calcException);

    // PathVariable -> recebe parametros na url
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return service.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return service.sub(numberOne, numberTwo);
    }

    @RequestMapping(value = "/multiplier/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplier(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {


        return service.multiply(numberOne, numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                             @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return service.div(numberOne, numberTwo);
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return service.med(numberOne, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {

        return service.squareRoot(numberOne);
    }
}
