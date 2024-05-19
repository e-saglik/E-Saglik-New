package Controller;

import DAO.BaseDAO;
import DAO.PaymentDAO;
import Entity.Payment;
import java.util.List;

public class PaymentController extends BaseController<Payment> {

    private PaymentDAO paymentDao;
    private Payment payment;
    private List<Payment> paymentList;

    public PaymentController() {

    }

   @Override
    public Payment GetEntityById(int id) {
        if (paymentDao == null) {
            paymentDao = new PaymentDAO();
        }
        paymentDao.GetPaymentById(id);
        return null;
    }

    @Override
    public List<Payment> GetEntityList() {
        if (paymentDao == null) {
            paymentDao = new PaymentDAO();
        }
        paymentDao.GetPaymentList();

        return paymentDao.GetPaymentList();
    }

    @Override
    public void UpdateEntity(int id, Payment payment) {
        if (paymentDao == null) {
            paymentDao = new PaymentDAO();
        }
        paymentDao.UpdatePayment(payment);
    }

    @Override
    public void DeleteEntity(int id) {
        if (paymentDao == null) {
            paymentDao = new PaymentDAO();
        }
        paymentDao.DeletePayment(id);
    }

}
