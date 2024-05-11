package Entity;

import java.util.Date;

public class TestResult extends BaseEntity {
    private Date date;
    private String testType;
    private String testName;
    private String testNormalValue;
    private String testValue;

    public TestResult() {
        
    }

    public TestResult(Date date, String testType, String testName, String testNormalValue, String testValue, int id, String name) {
        super(id, name);
        this.date = date;
        this.testType = testType;
        this.testName = testName;
        this.testNormalValue = testNormalValue;
        this.testValue = testValue;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestNormalValue() {
        return testNormalValue;
    }

    public void setTestNormalValue(String testNormalValue) {
        this.testNormalValue = testNormalValue;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String toString() {
        return "TestResult{" + "date=" + date + ", testType=" + testType + ", testName=" + testName + ", testNormalValue=" + testNormalValue + ", testValue=" + testValue + '}';
    }
    
        
}
