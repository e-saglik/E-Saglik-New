package DAO;

import Entity.Appointment;
import Entity.Patient;
import Entity.PolyClinic;
import jakarta.persistence.TypedQuery;

import java.time.LocalTime;
import java.util.List;

public class AppointmentDAO extends BaseDAO<Appointment> {

    public void createAppointment(Appointment appointment) {
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

    public void updateAppointment(Appointment appointment) {
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

    public void deleteAppointment(int id) {
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
