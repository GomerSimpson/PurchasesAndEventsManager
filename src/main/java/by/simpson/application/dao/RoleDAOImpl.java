package by.simpson.application.dao;

import by.simpson.application.entity.Role;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Role> getListRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role")
                .list();
    }

    public Role getRole(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);

        System.out.println(role.getUser());

        return role;
    }
}
