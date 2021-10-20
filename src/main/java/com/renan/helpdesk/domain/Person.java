package com.renan.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.renan.helpdesk.domain.enums.Profile;

public abstract class Person {
	
	protected Integer id;
	protected String name;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> profiles = new HashSet<>();
	protected LocalDate creationDate = LocalDate.now();
	public Person() {
		super();
		addProfile(Profile.CLIENT);
	}
	public Person(Integer id, String name, String cpf, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.senha = password;
		addProfile(Profile.CLIENT);

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String password) {
		this.senha = password;
	}
	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}
	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
}
