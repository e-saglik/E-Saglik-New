package Controller;

import DAO.BaseDAO;
import Entity.TestResult;
import java.util.List;

public class TestResultController extends BaseController<TestResult> {

    public BaseDAO getTestResultDao() {
        return testResultDao;
    }

    public void setTestResultDao(BaseDAO testResultDao) {
        this.testResultDao = testResultDao;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    private BaseDAO testResultDao;
    private TestResult testResult;
    private List<TestResult> testResultList;

    public TestResultController() {

    }

    @Override
    public void AddEntity(TestResult testResult) {

    }

    @Override
    public TestResult GetEntityById(int id) {
        return null;
    }

    @Override
    public List<TestResult> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
