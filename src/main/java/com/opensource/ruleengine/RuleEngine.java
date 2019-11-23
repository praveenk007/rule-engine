package com.opensource.ruleengine;

import java.util.Map;

/**
 * <p>
 *      Executes a given infix expression using facts provided
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
public class RuleEngine {

    /**
     * <p>
     *     This function executes a given infix expression using facts provided
     * </p>
     *
     * @param expression    infix expression
     * @param facts         facts
     * @return              evaluated value of infix expression, can be boolean or numeric value
     * @since 0.0.1
     */
    public Object execute(String expression, final Map<String, Object> facts) {
        for (Map.Entry<String, Object> entry: facts.entrySet()) {
            expression = expression.replace(entry.getKey(), entry.getValue().toString());
        } return new PostfixEvaluator().evaluate(new InfixToPostfix().postfix(expression));
    }
}
