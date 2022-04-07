package fr.baidem.tiroir.entity;



import java.util.UUID;

import javax.persistence.*;


import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "chaussettes")
public class Chaussette {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "couleur", length = 100)
	private String color;

	@Column(name = "saison", length = 100)
	private String season;
	
	@JoinColumn(name = "tiroir_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Tiroir drawer;

	public Chaussette() {
		
	}

	public Chaussette(String color, String season) {
		this.color = color;
		this.season = season;
	}

	public Chaussette(String color, String season, Tiroir drawer) {
		this(color, season);
		this.drawer = drawer;
	}

	public UUID getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public String getSeason() {
		return season;
	}

	public Tiroir getDrawer() {
		return drawer;
	}

	public void setDrawer(Tiroir drawer) {
		this.drawer = drawer;
	}

		
}
