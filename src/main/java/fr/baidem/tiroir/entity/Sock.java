package fr.baidem.tiroir.entity;

import javax.persistence.*;


@Entity
@Table(name = "socks")
@Embeddable
public class Sock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;
    
    @Column(name = "size")
    private int size;

    @Column(name = "style")
    @Enumerated(EnumType.STRING)
    private Style style;
    
    @Column(name = "season")
    @Enumerated(EnumType.STRING)
    private Season season;
    
    @ManyToOne
    @JoinColumn(name="drawer_id")
    private Drawer drawer;

    
    public Sock() {

    }
    
    public Sock(String brand, String color, int size) {
		this.brand = brand;
		this.color = color;
		this.size = size;
	}

	public Sock(String brand, String color, int size, Style style, Season season) {
		this(brand, color, size);
		this.style = style;
		this.season = season;
	}
	
	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public int getSize() {
		return size;
	}

	public Style getStyle() {
		return style;
	}

	public Season getSeason() {
		return season;
	}

    
    
    
    
}

    
