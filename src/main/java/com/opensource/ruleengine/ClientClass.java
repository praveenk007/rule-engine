package com.opensource.ruleengine;

import java.util.Map;

/**
 * @author praveenkamath
 **/
public class ClientClass {

    public boolean isAllowed(String conditionalExpression, String featureName, Map<String, Object> user) {
        return (Boolean) new RuleEngine().execute(conditionalExpression, user);
    }
}
