package DAO;

import Entity.Hospital;
import Entity.PolyClinic;
import Entity.Doctor;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class HospitalDAO extends BaseDAO<Hospital> {

    public HospitalDAO() {
        super();
    }

    public void CreateHospital(Hospital hospital) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(hospital);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Hospital> getHospitalList() {
        TypedQuery<Hospital> query = getEntityManager().createQuery("SELECT h FROM Hospital h ORDER BY h.id ASC", Hospital.class);
        List<Hospital> hospitalList = query.getResultList();
        for (Hospital hospital : hospitalList) {
            hospital.setPolyClinics(getPolyClinicsByHospitalId(hospital.getId()));
            hospital.setDoctors(getDoctorsByHospitalId(hospital.getId()));
        }
        return hospitalList;
    }

    private List<PolyClinic> getPolyClinicsByHospitalId(int hospitalId) {
        TypedQuery<PolyClinic> query = getEntityManager().createQuery("SELECT pc FROM PolyClinic pc WHERE pc.hospital.id = :hospitalId", PolyClinic.class);
        query.setParameter("hospitalId", hospitalId);
        return query.getResultList();
    }

    private List<Doctor> getDoctorsByHospitalId(int hospitalId) {
        TypedQuery<Doctor> query = getEntityManager().createQuery("SELECT d FROM Doctor d WHERE d.hospital.id = :hospitalId", Doctor.class);
        query.setParameter("hospitalId", hospitalId);
        return query.getResultList();
    }

    public void UpdateHospital(Hospital hospital) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(hospital);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteHospital(int id) {
        Hospital hospital = getEntityManager().find(Hospital.class, id);
        if (hospital != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(hospital);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Hospital getHospitalById(int id) {
        Hospital hospital = getEntityManager().find(Hospital.class, id);
        if (hospital != null) {
            hospital.setPolyClinics(getPolyClinicsByHospitalId(hospital.getId()));
            hospital.setDoctors(getDoctorsByHospitalId(hospital.getId()));
        }
        return hospital;
    }
}
