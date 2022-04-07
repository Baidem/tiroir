package fr.baidem.tiroir.entity;

import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_name", length = 100)
	private String userName;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "drawers")
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    private Set<Drawer> drawers;

	public User() {
	}
	
	public User(String userName) {
		this.userName = userName;
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

}
