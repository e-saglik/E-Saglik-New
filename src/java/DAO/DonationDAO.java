package DAO;

import Entity.Donation;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DonationDAO extends AbstractDAO<Donation> {

    public DonationDAO() {
        super();
    }

    public void CreateDonation(Donation donation) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(donation);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Donation> getDonationList() {
        TypedQuery<Donation> query = getEntityManager().createQuery("SELECT d FROM Donation d ORDER BY d.id ASC", Donation.class);
        return query.getResultList();
    }

    public void UpdateDonation(Donation donation) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(donation);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteDonation(int id) {
        Donation donation = getEntityManager().find(Donation.class, id);
        if (donation != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(donation);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Donation getDonationById(int id) {
        return getEntityManager().find(Donation.class, id);
    }
}
