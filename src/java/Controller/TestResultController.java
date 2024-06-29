package Controller;

import DAO.BaseDAO;
import DAO.TestResultDAO;
import Entity.TestResult;
import java.util.List;

public class TestResultController extends BaseController<TestResult> {

    public BaseDAO getTestResultDao() {
        return testResultDao;
    }

    public void setTestResultDao(TestResultDAO testResultDao) {
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

    private TestResultDAO testResultDao;
    private TestResult testResult;
    private List<TestResult> testResultList;

    public TestResultController() {

    }

   @Override
    public TestResult GetEntityById(int id) {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.getTestResultById(id);
        return null;
    }

    @Override
    public List<TestResult> GetEntityList() {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.getTestResultList();

        return testResultDao.getTestResultList();
    }

    @Override
    public void UpdateEntity(int id, TestResult testResult) {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.UpdateTestResult(testResult);
    }

    @Override
    public void DeleteEntity(int id) {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.DeleteTestResult(id);
    }


}
