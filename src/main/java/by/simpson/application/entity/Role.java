package by.simpson.application.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public Role(){
	}
	
	public Integer getId(){
		return id;
	}
	public Role(String role){
		this.role = role;
	}
	
	public String getRole(){
		return role;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
}
