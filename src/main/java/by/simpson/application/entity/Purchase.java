package by.simpson.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "purchase")
public class Purchase {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "price", nullable = false)
	private Long price;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public Purchase() {
	}

	public Purchase(String name, Date date, Long price) {
		this.name = name;
		this.date = date;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public Long getPrice() {
		return price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
