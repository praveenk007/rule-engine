package com.opensource.ruleengine;

/**
 * <p>
 *     This interface provides methods for implementing evaluators
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
public interface Evaluator {

    /**
     * <p>
     *      This function evaluates a simple expression consisting of 2 operands and 1 operator
     * </p>
     *
     * @param a             first operand
     * @param b             second operand
     * @param operatorEnum  operator
     * @return              output, either boolean or numeric value
     * @since 0.0.1
     */
    default Object evaluateSubExpressions(final Object a, final Object b, final Operator operatorEnum) {
        switch (operatorEnum) {
            case EQUALS:
                return a.equals(b);
            case GREATER_THAN:
                return (Double) a > (Double) b;
            case GREATER_THAN_EQUALS:
                return (Double) a >= (Double) b;
            case LESS_THAN:
                return (Double) a < (Double) b;
            case LESS_THAN_EQUALS:
                return (Double) a <= (Double) b;
            case AND:
                return (Boolean) a && (Boolean) b;
            case OR:
                return (Boolean) a || (Boolean) b;
        } throw new UnsupportedOperationException("Operator " + operatorEnum.getOperatorValue() + " is not supported");
    }

    /**
     * <p>
     *     This function evaluates a postfix expression
     * </p>
     *
     * @param postfix   postfix expression
     * @return          evaluated value of the expression, can be boolean or numeric
     * @since 0.0.1
     */
    Object evaluate(final String postfix);
}
