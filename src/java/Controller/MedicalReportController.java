package Controller;

import DAO.AbstractDAO;
import Entity.MedicalReport;
import java.util.List;

public class MedicalReportController extends BaseController<MedicalReport> {

    public AbstractDAO getMedicalReportDao() {
        return medicalReportDao;
    }

    public void setMedicalReportDao(AbstractDAO medicalReportDao) {
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

    private AbstractDAO medicalReportDao;
    private MedicalReport medicalReport;
    private List<MedicalReport> medicalReportList;

    public MedicalReportController() {

    }

    @Override
    public void AddEntity(MedicalReport medicalReport) {

    }

    @Override
    public MedicalReport GetEntityById(int id) {
        return null;
    }

    @Override
    public List<MedicalReport> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, MedicalReport medicalReport) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
