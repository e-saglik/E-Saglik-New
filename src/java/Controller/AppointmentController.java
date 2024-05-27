package Controller;

import DAO.AppointmentDAO;
import Entity.Appointment;
import java.util.List;

public class AppointmentController extends BaseController<Appointment> {

    private AppointmentDAO appointmentDao;
    private Appointment appointment;
    private List<Appointment> appointmentList;

    public AppointmentController() {

    }

    public AppointmentDAO getAppointmentDao() {
        if (this.appointmentDao == null) {
            this.appointmentDao = new AppointmentDAO();
        }
        return appointmentDao;
    }

    public void setAppointmentDao(AppointmentDAO appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<Appointment> getAppointmentList() {
        this.appointmentList = this.getAppointmentDao().GetAppointmentList();
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public void AddEntity(Appointment appointment) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.CreateAppointment(appointment);

    }

    @Override
    public Appointment GetEntityById(int id) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.GetAppointmentById(id);
        return null;
    }

    @Override
    public List<Appointment> GetEntityList() {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.GetAppointmentList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Appointment appointment) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.UpdateAppointment(appointment);
    }

    @Override
    public void DeleteEntity(int id) {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDAO();
        }
        appointmentDao.DeleteAppointment(id);
    }

}
