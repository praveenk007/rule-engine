package com.opensource.ruleengine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

/**
 * <p>
 *     This implementation evaluates postfix expression
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
public class PostfixEvaluator implements Evaluator {

    /**
     * holds operands
     */
    private final Deque<Object> operands = new ArrayDeque<>();

    /**
     * <p>
     *      This function evaluates a postfix expression
     *      1. Iterate through all tokens from space delimited postfix expression
     *      2. If token is an operator, pop 2 elements from dequeue
     *      2.1. If operator is math, send the 2 elements for calculation (a + b), else send for evaluation (a < b)
     *      2.2. Push the output to dequeue
     *      3. If token is not an operator, simply push it to dequeue
     *      4. Once done for all tokens, the only element left in dequeue should be the boolean / numeric output
     * </p>
     *
     * @param postfix   postfix expression
     * @return          evaluated value of postfix expression, can be boolean or numeric
     */
    @Override
    public Object evaluate(final String postfix) {
        final String[] strArr = postfix.split(" ");
        for(final String str: strArr) {
            final Optional<Operator> operatorEnum = Operator.getByOperatorName(str);
            if(operatorEnum.isPresent()) {
                final Object head1 = operands.pop();
                final Object head2 = operands.pop();
                if(operatorEnum.get().getType() == OperatorType.MATH) {
                    operands.push(Calculator.calculate((Double) head1, (Double) head2, operatorEnum.get()));
                } else {
                    operands.push(evaluateSubExpressions(head2, head1, operatorEnum.get()));
                }
            } else {
                try {
                    operands.push(Double.parseDouble(str));
                } catch (NumberFormatException e) {
                    operands.push(str);
                }
            }
        } return operands.pop();
    }
}
