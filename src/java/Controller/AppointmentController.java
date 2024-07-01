package Controller;

import DAO.AppointmentDAO;
import Entity.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AppointmentController extends BaseController<Appointment> {

    private AppointmentDAO appointmentDao;
    private EntityManagerFactory emf;
    private EntityManager em;

    public AppointmentController() {
        this.emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        this.em = emf.createEntityManager();
        this.appointmentDao = new AppointmentDAO(em);
    }

    public AppointmentDAO getAppointmentDao() {
        if (this.appointmentDao == null) {
            this.appointmentDao = new AppointmentDAO(em);
        }
        return appointmentDao;
    }

    public void setAppointmentDao(AppointmentDAO appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public List<Appointment> getAppointmentList() {
        return this.getAppointmentDao().getAppointmentList();
    }

    @Override
    public void AddEntity(Appointment appointment) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO(em);
        }
        appointmentDao.CreateAppointment(appointment);
    }

    @Override
    public Appointment GetEntityById(int id) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO(em);
        }
        return appointmentDao.getAppointmentById(id);
    }

    @Override
    public List<Appointment> GetEntityList() {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO(em);
        }
        return appointmentDao.getAppointmentList();
    }

    @Override
    public void UpdateEntity(int id, Appointment appointment) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO(em);
        }
        appointmentDao.UpdateAppointment(appointment);
    }

    @Override
    public void DeleteEntity(int id) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO(em);
        }
        appointmentDao.DeleteAppointment(id);
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
