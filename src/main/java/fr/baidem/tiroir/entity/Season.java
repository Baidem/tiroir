package fr.baidem.tiroir.entity;

public enum Season {
	SPRING("SPRING"),
	SUMMER("SUMMER"),
	AUTUMN("AUTUMN"),
	WINTER("WINTER");
	
	private String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
