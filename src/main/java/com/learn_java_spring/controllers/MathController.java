package com.learn_java_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn_java_spring.exceptions.UnsupportedMathOperationException;
import com.learn_java_spring.math.SimpleMath;
import com.learn_java_spring.converters.NumberConverter;

@RestController
public class MathController {
  private SimpleMath math = new SimpleMath();

  @GetMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @GetMapping("/sub/{numberOne}/{numberTwo}")
  public Double sub(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @GetMapping("/mult/{numberOne}/{numberTwo}")
  public Double mult(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @GetMapping("/div/{numberOne}/{numberTwo}")
  public Double div(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @GetMapping("/avg/{numberOne}/{numberTwo}")
  public Double avg(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
    if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @GetMapping("/square/{number}")
  public Double square(
      @PathVariable(value = "number") String number) throws Exception {
    if (!NumberConverter.isNumeric(number)) {
      throw new UnsupportedMathOperationException("Please set a numeric value");
    }

    return math.square(Math.sqrt(NumberConverter.convertToDouble(number)));
  }
}
