package DAO;

import Entity.MedicalReport;

import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class MedicalReportDAO extends BaseDAO<MedicalReport> {

    public MedicalReportDAO() {
        super();
    }

    public void CreateMedicalReport(MedicalReport medicalReport) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(medicalReport);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<MedicalReport> getMedicalReportList() {
        TypedQuery<MedicalReport> query = getEntityManager().createQuery("SELECT m FROM MedicalReport m ORDER BY m.id ASC", MedicalReport.class);
        List<MedicalReport> medicalReportList = query.getResultList();
        return medicalReportList;
    }

    public void UpdateMedicalReport(MedicalReport medicalReport) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(medicalReport);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteMedicalReport(int id) {
        MedicalReport medicalReport = getEntityManager().find(MedicalReport.class, id);
        if (medicalReport != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(medicalReport);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public MedicalReport getMedicalReportById(int id) {
        MedicalReport medicalReport = getEntityManager().find(MedicalReport.class, id);
        return medicalReport;
    }
}
