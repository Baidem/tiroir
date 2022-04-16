package fr.baidem.tiroir.entity;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "drawers")
public class Drawer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", length = 100)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="drawer")
    private Set<Sock> socks;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
		
	public Drawer() {

	}

	public Drawer(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Sock> getSocks() {
		return socks;
	}

	
		
		
}
