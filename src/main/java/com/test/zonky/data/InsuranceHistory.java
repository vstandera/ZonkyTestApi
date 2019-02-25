package com.test.zonky.data;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Generated object InsuranceHistory form JSON.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsuranceHistory {

    private String policyPeriodFrom;
    private String policyPeriodTo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPolicyPeriodFrom() {
        return policyPeriodFrom;
    }

    public void setPolicyPeriodFrom(String policyPeriodFrom) {
        this.policyPeriodFrom = policyPeriodFrom;
    }

    public String getPolicyPeriodTo() {
        return policyPeriodTo;
    }

    public void setPolicyPeriodTo(String policyPeriodTo) {
        this.policyPeriodTo = policyPeriodTo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
