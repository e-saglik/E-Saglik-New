package Controller;

import DAO.BaseDAO;
import Entity.VaccinationSchedule;
import java.util.List;

public class VaccinationScheduleController extends BaseController<VaccinationSchedule> {

    private BaseDAO scheduleDao;
    private VaccinationSchedule schedule;
    private List<VaccinationSchedule> scheduleList;

    public BaseDAO getScheduleDao() {
        return scheduleDao;
    }

    public void setScheduleDao(BaseDAO scheduleDao) {
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
    public void AddEntity(VaccinationSchedule vaccine) {

    }

    @Override
    public VaccinationSchedule GetEntityById(int id) {
        return null;
    }

    @Override
    public List<VaccinationSchedule> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
