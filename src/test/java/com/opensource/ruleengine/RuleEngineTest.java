package com.opensource.ruleengine;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author praveenkamath
 **/
public class RuleEngineTest {

    @Test
    public void rule1() {
        final String expression = "( age > 25 AND gender == \"Male\" ) OR ( past_order_amount > 10000 )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("age", 30);
        facts.put("gender", "Male");
        facts.put("past_order_amount", 9000);
        boolean op = (Boolean) new RuleEngine().execute(expression, facts);
        assertTrue(op);
    }

    @Test
    public void rule2() {
        final String expression = "( age > 25 AND gender == Male ) OR ( past_order_amount > 10000 )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("age", 30);
        facts.put("gender", "Female");
        facts.put("past_order_amount", 9000);
        boolean op = (Boolean) new RuleEngine().execute(expression, facts);
        assertFalse(op);
    }

    @Test
    public void rule3() {
        final String expression = "( age > 25 AND gender == Mal)e ) OR ( past_order_amount > 10000 )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("age", 30);
        facts.put("gender", "Mal)e");
        facts.put("past_order_amount", 9000);
        boolean op = (Boolean) new RuleEngine().execute(expression, facts);
        assertTrue(op);
    }

    @Test
    public void rule4() {
        final String expression = "( a + b >= 20 )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("a", 20);
        facts.put("b", 10);
        boolean op = (Boolean) new RuleEngine().execute(expression, facts);
        assertTrue(op);
    }

    @Test
    public void rule5() {
        final String expression = "( a + b >= 20 )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("a", 4);
        facts.put("b", 10);
        boolean op = (Boolean) new RuleEngine().execute(expression, facts);
        assertFalse(op);
    }

    @Test
    public void rule6() {
        final String expression = "( a + b )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("a", 4);
        facts.put("b", 10);
        double op = (Double) new RuleEngine().execute(expression, facts);
        assertEquals(14, op, 1);
    }

    @Test
    public void rule7() {
        final String expression = "( a + b )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("a", 4);
        facts.put("b", -10);
        double op = (Double) new RuleEngine().execute(expression, facts);
        assertEquals(-6, op, 1);
    }

    @Test
    public void rule8() {
        final String expression = "( a + b )";
        final Map<String, Object> facts = new HashMap<>();
        facts.put("a", 4);
        facts.put("b", 9);
        double op = (Double) new RuleEngine().execute(expression, facts);
        assertNotEquals(10, op, 1);
    }
}
