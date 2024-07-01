package Controller;

import DAO.AbstractDAO;
import DAO.VaccinationScheduleDAO;
import Entity.VaccinationSchedule;
import java.util.List;

public class VaccinationScheduleController extends BaseController<VaccinationSchedule> {

    private VaccinationScheduleDAO scheduleDao;
    private VaccinationSchedule schedule;
    private List<VaccinationSchedule> scheduleList;

    public AbstractDAO getScheduleDao() {
        return scheduleDao;
    }

    public void setScheduleDao(VaccinationScheduleDAO scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public VaccinationSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(VaccinationSchedule schedule) {
        this.schedule = schedule;
    }

    public List<VaccinationSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<VaccinationSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public VaccinationScheduleController() {

    }

   @Override
    public VaccinationSchedule GetEntityById(int id) {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.getVaccinationScheduleById(id);
        return null;
    }

    @Override
    public List<VaccinationSchedule> GetEntityList() {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.getVaccinationScheduleList();

        return scheduleDao.getVaccinationScheduleList();
    }

    @Override
    public void UpdateEntity(int id, VaccinationSchedule vaccinationSchedule) {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.UpdateVaccinationSchedule(vaccinationSchedule);
    }

    @Override
    public void DeleteEntity(int id) {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.DeleteVaccinationSchedule(id);
    }

    @Override
    public void AddEntity(VaccinationSchedule entity) {
        if (scheduleDao == null) {
            scheduleDao = new VaccinationScheduleDAO();
        }
        scheduleDao.CreateVaccinationSchedule(schedule);
    }


}
