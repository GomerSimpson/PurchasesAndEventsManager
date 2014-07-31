package by.simpson.application.dao;

import by.simpson.application.entity.Role;
import java.util.List;

public interface RoleDAO
{
	public List<Role> getListRoles();
	public Role getRole(Integer id);
}
