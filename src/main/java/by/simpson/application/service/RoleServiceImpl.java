package by.simpson.application.service;

import by.simpson.application.dao.RoleDAO;
import by.simpson.application.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService
{

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public List<Role> getListRoles() {
        return roleDAO.getListRoles();
    }
    
    @Transactional
    public Role getRole(Integer id){
        return roleDAO.getRole(id);
    }
}
