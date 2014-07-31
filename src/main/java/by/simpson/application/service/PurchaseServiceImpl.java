package by.simpson.application.service;

import by.simpson.application.dao.PurchaseDAO;
import by.simpson.application.entity.Purchase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl
{

    @Autowired
    private PurchaseDAO purchaseDAO;

    @Transactional
    public List<Purchase> getListPurchases() {
        return purchaseDAO.getListPurchases();
    }
}
