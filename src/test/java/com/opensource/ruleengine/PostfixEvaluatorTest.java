package com.opensource.ruleengine;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author praveenkamath
 **/
public class PostfixEvaluatorTest {

    @Test
    public void eval1() {
        final String postfix = "3 2 > hey hey == | 10 9 <= world world == | &";
        final Object op = new PostfixEvaluator().evaluate(postfix);
        assertTrue((Boolean) op);
    }

    @Test
    public void eval2() {
        final String postfix = "3 2 > hey hey == | 10 9 <= world wor == | &";
        final Object op = new PostfixEvaluator().evaluate(postfix);
        assertFalse((Boolean) op);
    }

    @Test
    public void eval3() {
        final String postfix = "3 2 > hey hello == &";
        final Object op = new PostfixEvaluator().evaluate(postfix);
        assertFalse((Boolean) op);
    }

    @Test
    public void eval4() {
        final String postfix = "3 2 > hey hello == |";
        final Object op = new PostfixEvaluator().evaluate(postfix);
        assertTrue((Boolean) op);
    }
}
