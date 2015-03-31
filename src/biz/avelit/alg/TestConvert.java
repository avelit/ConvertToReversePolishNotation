package biz.avelit.alg;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConvert {

  @Test
  public void testSimple() {
    String notation = "10+10*10";
    String result = (new ConvertToReversePolishNotation(notation)).convert();
    String expectedResult = "10 10 10 * + ";
    assertEquals(expectedResult, result);
  }

  @Test
  public void testBraces() {
    String notation = "(10+10)*10";
    String result = (new ConvertToReversePolishNotation(notation)).convert();
    String expectedResult = "10 10 + 10 * ";
    assertEquals(expectedResult, result);
  }

}
