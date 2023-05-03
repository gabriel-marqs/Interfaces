package entities.service;

public class PagSeguroService implements OnlinePaymentService {
	
	public double paymentFee(Double amount) {
		return amount * 0.01;
	}
	
	public double interest(Double amount, Integer months) {		
		return amount * (0.01 * months);
	}
}
