package Controller;

import DAO.AbstractDAO;
import DAO.TestResultDAO;
import Entity.TestResult;
import java.util.List;

public class TestResultController extends BaseController<TestResult> {

    public AbstractDAO getTestResultDao() {
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
        testResultDao.GetById(id);
        return null;
    }

    @Override
    public List<TestResult> GetEntityList() {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.GetList();

        return testResultDao.GetList();
    }

    @Override
    public void UpdateEntity(int id, TestResult testResult) {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.Update(testResult);
    }

    @Override
    public void DeleteEntity() {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.Delete(testResult);
    }

    @Override
    public void AddEntity(TestResult entity) {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.Create(testResult);
    }


}
