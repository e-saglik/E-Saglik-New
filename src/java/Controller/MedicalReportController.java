package Controller;

import DAO.AbstractDAO;
import DAO.MedicalReportDAO;
import Entity.MedicalReport;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MedicalReportController extends BaseController<MedicalReport> implements Serializable{

    @EJB
    private MedicalReportDAO medicalReportDao;

    private MedicalReport medicalReport;
    private List<MedicalReport> medicalReportList;

    public MedicalReportController() {
        super(MedicalReport.class);
    }

    public AbstractDAO getMedicalReportDao() {
        if (this.medicalReportDao == null) {
            this.medicalReportDao = new MedicalReportDAO();
        }
        return medicalReportDao;
    }

    public void setMedicalReportDao(MedicalReportDAO medicalReportDao) {
        this.medicalReportDao = medicalReportDao;
    }

    public MedicalReport getMedicalReport() {
        return medicalReport;
    }

    public void setMedicalReport(MedicalReport medicalReport) {
        this.medicalReport = medicalReport;
    }

    public List<MedicalReport> getMedicalReportList() {
        this.medicalReportList = this.getMedicalReportDao().GetList();
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    @Override
    public void AddEntity() {
        getMedicalReportDao().Create(this.entity);
        this.entity = new MedicalReport();

    }

    @Override
    public MedicalReport GetEntityById(int id) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.GetById(id);

        return null;
    }

    @Override
    public List<MedicalReport> GetEntityList() {
        return getMedicalReportDao().GetList();
    }

    @Override
    public void UpdateEntity() {
       getMedicalReportDao().Update(medicalReport);
        this.entity = new MedicalReport();

    }

    @Override
    public void DeleteEntity() {
        medicalReportDao.Delete(entity);
        this.entity = new MedicalReport();

    }

}
