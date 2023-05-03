package entities;

import java.time.LocalDate;

public class Contract {
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	private Installment[] instalmments;

	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Installment[] getInstalmments() {
		return instalmments;
	}

	public void setInstalmments(Installment[] instalmments) {
		this.instalmments = instalmments;
	}
	
	
	
}
