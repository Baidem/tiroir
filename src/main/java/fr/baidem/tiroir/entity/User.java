package fr.baidem.tiroir.entity;

import java.util.List;


import javax.persistence.*;


//import org.springframework.lang.NonNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_name", length = 100)
	private String userName;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "first_name", length = 100)
	private String firstName;

	@Column(name = "last_name", length = 100)
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Role> roles;
	
//	@JoinColumn(name = "drawer_id")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@NonNull
//	private Drawer drawer;

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Role> getRoles() {
		return roles;
	}	
}
