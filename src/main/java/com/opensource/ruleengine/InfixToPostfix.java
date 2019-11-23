package com.opensource.ruleengine;

import java.util.*;

/**
 * <p>
 *     This class is responsible for converting an infix expression to postfix expression
 * </p>
 *
 * @author praveenkamath
 * @since 0.0.1
 **/
class InfixToPostfix {

    /**
     * This data structure holds operators in an ordered LIFO manner
     */
    private static final Deque<String> OPERATORS_STACK = new ArrayDeque<>();

    /**
     * This data structure holds the postfix expression
     */
    private static final List<String> POSTFIX_LIST = new ArrayList<>();

    /**
     * This data structure holds priority of supported operators
     */
    private static Map<String, Integer> precedence = new HashMap<>();

    InfixToPostfix() {
        precedence.put("*", 4);
        precedence.put("/", 4);
        precedence.put("-", 3);
        precedence.put("+", 3);
        precedence.put("<", 2);
        precedence.put("<=", 2);
        precedence.put(">", 2);
        precedence.put(">=", 2);
        precedence.put("==", 2);
        precedence.put("&", 1);
        precedence.put("|", 1);
        precedence.put("(", 0);
        precedence.put(")", 0);
    }

    /**
     *  <p>
     *      This function converts an infix expression to postfix expression
     *  </p>
     *
     * @param infix     infix expression
     * @return          postfix expression
     * @since 0.0.1
     */
    String postfix(String infix) {
        infix = infix.replace(" and ", " & ")
                .replace(" AND ", " & ")
                .replace(" or ", " | ")
                .replace(" OR ", " | ");
        createPostfix(infix);
        return getPostfix();
    }

    /**
     * <p>
     *     Parses postfix data structure and constructs string postfix expression
     * </p>
     *
     * @return  postfix expression
     * @since 0.0.1
     */
    private String getPostfix() {
        final StringBuilder sb = new StringBuilder();
        for (final String str: POSTFIX_LIST) {
            sb.append(str);
        }
        return sb.toString().trim();
    }

    /**
     * <p>
     *      This function constructs postfix expression in data structure
     * </p>
     *
     * @param infix infix expression
     * @since 0.0.1
     */
    private void createPostfix(final String infix) {
        final String[] infixChars = infix.split(" ");
        for (String character: infixChars) {
            if(character.equalsIgnoreCase(" ")) {
                continue;
            }
            if(!precedence.containsKey(character)) {
                POSTFIX_LIST.add(character + " ");
            } else if("(".equals(character)) {
                OPERATORS_STACK.push(character);
            } else if(")".equals(character)) {
                String top = OPERATORS_STACK.pop();
                while(!top.equals("(")) {
                    POSTFIX_LIST.add(top + " ");
                    top = OPERATORS_STACK.pop();
                }
            } else {
                while(!OPERATORS_STACK.isEmpty() && precedence.get(OPERATORS_STACK.peek()) >= precedence.get(character)) {
                    POSTFIX_LIST.add(OPERATORS_STACK.pop() + " ");
                } OPERATORS_STACK.push(character);
            }
        }
        flushResidualOperators();
    }

    /**
     * <p>
     *     Flushes the remaining portion of data structure which holds operators
     * </p>
     *
     * @since 0.0.1
     */
    private void flushResidualOperators() {
        while(!OPERATORS_STACK.isEmpty()) {
            POSTFIX_LIST.add(OPERATORS_STACK.pop());
        }
    }
}
