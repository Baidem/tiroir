package fr.baidem.tiroir.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;


import org.hibernate.annotations.Type;


@Entity
@Table(name = "tiroirs")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Tiroir {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "nom")
	private String name;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drawer")
	private List<Chaussette> socks;

	public Tiroir(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chaussette> getSocks() {
		return socks;
	}

	public void setSocks(List<Chaussette> socks) {
		this.socks = socks;
	}

	public Tiroir() {
		super();
	}

	
}
