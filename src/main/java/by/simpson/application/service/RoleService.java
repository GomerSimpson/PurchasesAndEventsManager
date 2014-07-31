package by.simpson.application.service;

import by.simpson.application.entity.Role;
import java.util.List;

public interface RoleService
{
    public List<Role> getListRoles();
    public Role getRole(Integer id);
}
