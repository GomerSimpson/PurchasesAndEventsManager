package by.simpson.application.dao;

import by.simpson.application.entity.Purchase;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO
{
       @Autowired
    private SessionFactory sessionFactory;

    public List<Purchase> getListPurchases() {
        return sessionFactory.getCurrentSession().createQuery("from Purchase")
                .list();
    }
}
