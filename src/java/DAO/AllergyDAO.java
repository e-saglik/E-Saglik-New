package DAO;

import Entity.Allergy;
import Entity.Patient;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AllergyDAO extends BaseDAO<Allergy> {

    private PatientDAO patientDAO;

    public AllergyDAO() {
        super();
        this.patientDAO = new PatientDAO(); // PatientDAO'nun JPA versiyonunu kullanıyoruz
    }

    public void createAllergy(Allergy allergy) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(allergy);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Allergy> getAllergyList() {
        TypedQuery<Allergy> query = entityManager.createQuery("SELECT a FROM Allergy a ORDER BY a.id ASC", Allergy.class);
        return query.getResultList();
    }

    public void updateAllergy(Allergy allergy) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(allergy);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAllergy(int id) {
        try {
            entityManager.getTransaction().begin();
            Allergy allergy = entityManager.find(Allergy.class, id);
            if (allergy != null) {
                entityManager.remove(allergy);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Allergy getAllergyById(int id) {
        Allergy allergy = null;
        try {
            allergy = entityManager.find(Allergy.class, id);
            if (allergy != null) {
                int patientId = allergy.getPatient().getId(); // Allergy nesnesinde Patient'a ulaşmak için bir metod olduğunu varsayıyoruz
                Patient patient = patientDAO.getPatientById(patientId); // PatientDAO'nun JPA versiyonu ile hasta bilgisini alıyoruz
                allergy.setPatient(patient); // Allergy nesnesine patient bilgisini set ediyoruz
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allergy;
    }
}
