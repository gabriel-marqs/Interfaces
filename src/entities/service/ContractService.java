package entities.service;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;


public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}



	public void processContract(Contract contract, Integer months) {
		
		Installment[] installment = new Installment[months];
		double value = contract.getTotalValue() / months;
		
		for (int i = 0; i < months; i++) {
		
		LocalDate dueDate = contract.getDate().plusMonths(i + 1);		
		
		
		double newValue = value + onlinePaymentService.interest(value, i + 1);
		
		newValue += onlinePaymentService.paymentFee(newValue);
		
		installment[i] = new Installment(dueDate, newValue);		
		
		}
		
		contract.setInstalmments(installment);
	}
}
