package by.simpson.application.service;

import by.simpson.application.dao.EventDAO;
import by.simpson.application.entity.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService
{

    @Autowired
    private EventDAO eventDAO;

    @Transactional
    public List<Event> getListEvents() {
        return  eventDAO.getListEvents();
    }
}
