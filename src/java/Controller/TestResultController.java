package Controller;

import DAO.TestResultDAO;
import Entity.TestResult;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TestResultController extends BaseController<TestResult> implements Serializable {

    @EJB
    private TestResultDAO testResultDao;
    private TestResult testResult;
    private List<TestResult> testResultList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public TestResultController() {
        super(TestResult.class);
    }

    public TestResultDAO getTestResultDao() {
        if (this.testResultDao == null) {
            this.testResultDao = new TestResultDAO();
        }
        return testResultDao;
    }

    public void setTestResultDao(TestResultDAO testResultDao) {
        this.testResultDao = testResultDao;
    }

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getTestResultDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.testResult = new TestResult();
    }

    public void updateForm(TestResult testResult) {
        this.testResult = testResult;
    }

    public TestResult getTestResult() {
        if (testResult == null) {
            testResult = new TestResult();
        }
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public List<TestResult> getTestResultList() {
        this.testResultList = this.getTestResultDao().GetList();
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    @Override
    public void AddEntity() {
        getTestResultDao().Create(testResult);
        testResult = new TestResult();
    }

    @Override
    public TestResult GetEntityById(int id) {
        if (getTestResultDao() == null) {
            testResultDao = new TestResultDAO();
        }
        return getTestResultDao().GetById(id);
    }

    @Override
    public List<TestResult> GetEntityList() {
        return getTestResultDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getTestResultDao().Update(testResult);
        testResult = new TestResult();
    }

    @Override
    public void DeleteEntity() {
        getTestResultDao().Delete(testResult);
        testResult = new TestResult();
    }
}
