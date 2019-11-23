package com.opensource.ruleengine;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author praveenkamath
 **/
public class InfixToPostfixTest {

    @Test
    public void postfix() {
        final String infix = "( a > 2 or b == hey ) and ( c <= 9 or d == world )";
        final String postfix = new InfixToPostfix().postfix(infix);
        assertEquals("a 2 > b hey == | c 9 <= d world == | &", postfix);
    }

    @Test
    public void postfixMix() {
        final String infix = "( a + c > 2 or b == hey ) and ( c <= 9 or d == world )";
        final String postfix = new InfixToPostfix().postfix(infix);
        assertEquals("a c + 2 > b hey == | c 9 <= d world == | &", postfix);
    }

    @Test
    public void postfix1() {
        final String infix = "( a + b ) * c";
        final String postfix = new InfixToPostfix().postfix(infix);
        assertEquals("a b + c *", postfix);
    }
}
