package com.opensource.ruleengine;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 *     This enum holds all supported operators
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
enum Operator {

    /**
     * equality operator
     */
    EQUALS("==", OperatorType.LOGICAL),

    /**
     * less than operator
     */
    LESS_THAN("<", OperatorType.LOGICAL),

    /**
     * greater than operator
     */
    GREATER_THAN(">", OperatorType.LOGICAL),

    /**
     * less than equals operator
     */
    LESS_THAN_EQUALS("<=", OperatorType.LOGICAL),

    /**
     * greater than equals operator
     */
    GREATER_THAN_EQUALS(">=", OperatorType.LOGICAL),

    /**
     * and operator
     */
    AND("&", OperatorType.LOGICAL),

    /**
     * or operator
     */
    OR("|", OperatorType.LOGICAL),

    /**
     * division operator
     */
    DIVISION("/", OperatorType.MATH),

    /**
     * multiplication operator
     */
    MULTIPLICATION("*", OperatorType.MATH),

    /**
     * additive operator
     */
    ADDITION("+", OperatorType.MATH),

    /**
     * subtractive operator
     */
    SUBTRACTION("-", OperatorType.MATH);

    /**
     * operator value
     */
    private String          operatorValue;

    /**
     * operator type
     */
    private OperatorType    type;

    /**
     * <p>
     *     Sets operator value and type
     * </p>
     *
     * @param operator  operator value
     * @param type      operator type
     * @since 0.0.1
     */
    Operator(final String operator, final OperatorType type) {
        this.operatorValue  =   operator;
        this.type           =   type;
    }

    /**
     * <p>
     *     Fetches operator value
     * </p>
     *
     * @return  operator value
     * @since 0.0.1
     */
    String getOperatorValue() {
        return this.operatorValue;
    }

    /**
     * <p>
     *     Fetches operator type
     * </p>
     *
     * @return  operator type
     * @since 0.0.1
     */
    OperatorType getType() {
        return this.type;
    }

    /**
     * <p>
     *     Fetches operator by operator name
     * </p>
     *
     * @param operator  operator name
     * @return          operator
     * @since 0.0.1
     */
    static Optional<Operator> getByOperatorName(final String operator) {
        return Arrays.stream(Operator.values()).filter(operatorEnum -> operatorEnum.getOperatorValue().equals(operator)).findFirst();
    }
}
