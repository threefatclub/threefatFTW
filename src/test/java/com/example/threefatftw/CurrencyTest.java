package com.example.threefatftw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

  @Test
  void convertTest() {
    var x = Currency.convert(1,2);
    Assertions.assertTrue(x[0]>0);
    Assertions.assertTrue(x[1]>0);
  }

}
