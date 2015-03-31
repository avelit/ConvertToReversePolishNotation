package biz.avelit.alg;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConvertToReversePolishNotation {

  private String notation;
  private static final Map<Character,Integer> priority = new HashMap<Character,Integer>(){
    private static final long serialVersionUID = 8621352543443673885L;
    {
    put('(', 1);
    put('*', 3);
    put('/', 3);
    put('+', 2);
    put('-', 2);
    }
  };
  
  public ConvertToReversePolishNotation(String notation) {
    this.notation = notation;
  }

  public static void main(String[] args) {

  }

  public String convert() {

    Deque<Character> stack = new LinkedList<>();
    List<Object> listNotation = new ArrayList<>();
    Integer number = null; 
    
    for (char c : notation.toCharArray()) {
    
      if (isDigit(c)){
        if (number == null) {
          number = c - '0';
        } else {
          number = number * 10 + (c - '0');
        }
      
      } else {
        if (number != null) {
          listNotation.add(number);
        }
        number = null;
        if (c == '(') {
          stack.push(c);
        } else if ((c == ')')){
          char operator;
          do {
            operator = stack.pop();
            if (operator != '(') {
              listNotation.add(operator);
            }
          } while ((operator != '(') && (stack.size() > 0));
        //operators here  
        } else {
          int priorityLocalOperator = priority.get(c);
          int priorityOperatorFromStack;
          char operator;
          while (stack.size() > 0) {
            operator = stack.pop();
            priorityOperatorFromStack = priority.get(operator);
            if (priorityOperatorFromStack >= priorityLocalOperator) {
              listNotation.add(operator);
            } else {
              stack.push(operator);
              break;
            }
          };
          stack.push(c);
        }
      }
    }
    
    if (number != null) {
      listNotation.add(number);
    }
    for (char operator : stack) {
      listNotation.add(operator);
    }
    
    StringBuilder stringBuilder = new StringBuilder();
    for (Object object : listNotation) {
      stringBuilder.append(object).append(" ");
    }
 
 /*   —канировать список токенов слева направо.
    ||≈сли токен €вл€етс€ операндом, то добавить его в конец выходного списка.
    ||≈сли токен €вл€етс€ левой скобкой, положить его в opstack.
    ||≈сли токен €вл€етс€ правой скобкой, то выталкивать элементы из opstack пока не будет найдена соответствующа€ лева€ скобка. 
    || аждый оператор добавл€ть в конец выходного списка.
    ||≈сли токен €вл€етс€ оператором *, /, + или -, поместить его в opstack. 
    ||ќднако, перед этим вытолкнуть любой из операторов, уже наход€щихс€ в opstack, если он имеет больший или равный приоритет, 
    ||и добавить его в результирующий список.
    #.  огда входное выражение будет полностью обработано, проверить opstack. 
    Ћюбые операторы, всЄ ещЄ наход€щиес€ в нЄм, следует вытолкнуть и добавить в конец итогового списка.*/    
    
    return stringBuilder.toString();
  }

  private boolean isDigit(char c) {
    int check = c - '0';
    return check <=9 && check >= 0;
  }

}
