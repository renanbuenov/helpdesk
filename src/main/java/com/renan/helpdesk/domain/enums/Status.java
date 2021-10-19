package com.renan.helpdesk.domain.enums;

public enum Status {

	ADMINI(0, "OPENED"), CLIENT(1, "RUNNING"), TECH(2, "FINISHED");

	private Integer code;
	private String description;

	private Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Status x : Status.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid status");
	}
}
