package DAO;

import Entity.Appointment;
import Entity.Patient;
import Entity.PolyClinic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalTime;
import java.util.List;

public class AppointmentDAO extends AbstractDAO<Appointment> {

    public AppointmentDAO(EntityManager em) {
        super();
    }

    public void CreateAppointment(Appointment appointment) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(appointment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Appointment> getAppointmentList() {
        TypedQuery<Appointment> query = entityManager.createQuery("SELECT a FROM Appointment a ORDER BY a.id ASC", Appointment.class);
        return query.getResultList();
    }

    public void UpdateAppointment(Appointment appointment) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(appointment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteAppointment(int id) {
        try {
            entityManager.getTransaction().begin();
            Appointment appointment = entityManager.find(Appointment.class, id);
            if (appointment != null) {
                entityManager.remove(appointment);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Appointment getAppointmentById(int id) {
        Appointment appointment = null;
        try {
            appointment = entityManager.find(Appointment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointment;
    }
}
