package Controller;

import DAO.AbstractDAO;
import DAO.MedicalReportDAO;
import Entity.MedicalReport;
import java.util.List;

public class MedicalReportController extends BaseController<MedicalReport> {

    private MedicalReportDAO medicalReportDao;
    private MedicalReport medicalReport;
    private List<MedicalReport> medicalReportList;

    public MedicalReportController() {

    }

    public AbstractDAO getMedicalReportDao() {
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
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    @Override
    public void AddEntity(MedicalReport medicalReport) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.CreateMedicalReport(medicalReport);

    }

    @Override
    public MedicalReport GetEntityById(int id) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.getMedicalReportById(id);

        return null;
    }

    @Override
    public List<MedicalReport> GetEntityList() {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.getMedicalReportList();

        return null;
    }

    @Override
    public void UpdateEntity(int id, MedicalReport medicalReport) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.UpdateMedicalReport(medicalReport);

    }

    @Override
    public void DeleteEntity(int id) {
        if (medicalReportDao == null) {
            medicalReportDao = new MedicalReportDAO();
        }
        medicalReportDao.DeleteMedicalReport(id);

    }

}
