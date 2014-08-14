/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.simpson.application.dao;

import by.simpson.application.entity.Event;
import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Event> getListEvents() {
        return sessionFactory.getCurrentSession().createQuery("from Event")
                .list();
    }

}
