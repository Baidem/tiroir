package fr.baidem.tiroir.entity;

public enum Style {
	SPORT_SHORT("SPORT_SHORT"),
	SPORT_LONG("SPORT_LONG"),
	CITY_SHORT("CITY_SHORT"),
	CITY_LONG("CITY_LONG");

    private String value;

    Style(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}