package com.renan.helpdesk.domain.enums;

public enum Profile {

	ADMINI(0, "ROLE_ADMIN"), CLIENT(1, "ROLE_CLIENT"), TECH(2, "ROLE_TECH");

	private Integer code;
	private String description;

	private Profile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Profile x : Profile.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid profile");
	}
}
