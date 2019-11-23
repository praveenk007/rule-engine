package com.opensource.ruleengine;

/**
 * <p>
 *     This class calculates the value of a math operation
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
class Calculator {

    /**
     * <p>
     *     This method calculates the value of the math operation specified by operator field
     * </p>
     *
     * @param a         first operand
     * @param b         second operand
     * @param operator  math operator
     * @return          the output of the math operation
     */
    static double calculate(final double a, final double b, final Operator operator) {
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case DIVISION:
                return a/b;
            case MULTIPLICATION:
                return a * b;
        } throw new UnsupportedOperationException("The operator " + operator.getOperatorValue() + " is not supported.");
    }
}
