package Controller;

import DAO.AbstractDAO;
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
        this.entity = new TestResult();
    }

    public void updateForm(TestResult testResult) {
        this.entity = testResult;
    }

    public TestResultDAO getTestResultDao() {
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

    

   @Override
    public void AddEntity() {
        if (testResultDao == null) {
            testResultDao = new TestResultDAO();
        }
        testResultDao.Create(testResult);

    }

    @Override
    public TestResult GetEntityById(int id) {
        if (getTestResultDao() == null) {
            testResultDao = new TestResultDAO();
        }
        getTestResultDao().GetById(id);
        return null;
    }

    @Override
    public List<TestResult> GetEntityList() {
        return getTestResultDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        if (getTestResultDao() == null) {
            testResultDao = new TestResultDAO();
        }
        getTestResultDao().Update(testResult);
    }

    @Override
    public void DeleteEntity() {
        if (getTestResultDao() == null) {
            testResultDao = new TestResultDAO();
        }
        getTestResultDao().Delete(testResult);
    }


}
