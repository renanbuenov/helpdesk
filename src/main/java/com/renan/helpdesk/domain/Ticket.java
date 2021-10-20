package com.renan.helpdesk.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.renan.helpdesk.domain.enums.Priority;
import com.renan.helpdesk.domain.enums.Status;

public class Ticket {
	
	private Integer id;
	private LocalDate dateOpened = LocalDate.now();
	private LocalDate dateClosed;
	private Priority priority;
	private Status status;
	private String title;
	private String observation;
	
	private Technician technician;
	private Client client;
	
	public Ticket() {
		super();
	}

	public Ticket(Integer id, Priority priority, Status status, String title, String observation, Technician technician,
			Client client) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.observation = observation;
		this.technician = technician;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(LocalDate dateOpened) {
		this.dateOpened = dateOpened;
	}

	public LocalDate getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDate dateClosed) {
		this.dateClosed = dateClosed;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
}
