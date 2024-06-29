package DAO;

import Entity.Disease;
import Entity.Patient;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DiseaseDAO extends BaseDAO<Disease> {

    private PatientDAO patientDAO;

    public DiseaseDAO() {
        super();
        this.patientDAO = new PatientDAO(); // PatientDAO'nun JPA versiyonunu kullanıyoruz
    }

    public void createDisease(Disease disease) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(disease);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Disease> getDiseaseList() {
        TypedQuery<Disease> query = entityManager.createQuery("SELECT d FROM Disease d ORDER BY d.id ASC", Disease.class);
        return query.getResultList();
    }

    public void updateDisease(Disease disease) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(disease);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDisease(int id) {
        try {
            entityManager.getTransaction().begin();
            Disease disease = entityManager.find(Disease.class, id);
            if (disease != null) {
                entityManager.remove(disease);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Disease getDiseaseById(int id) {
        Disease disease = null;
        try {
            disease = entityManager.find(Disease.class, id);
            if (disease != null) {
                int patientId = disease.getPatient().getId(); // Disease nesnesinde Patient'a ulaşmak için bir metod olduğunu varsayıyoruz
                Patient patient = patientDAO.getPatientById(patientId); // PatientDAO'nun JPA versiyonu ile hasta bilgisini alıyoruz
                disease.setPatient(patient); // Disease nesnesine patient bilgisini set ediyoruz
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disease;
    }
}
