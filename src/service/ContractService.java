package service;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}




	public void processContract(Contract contract, int months) {
		
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 7, 5), 206.04));
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 8, 5), 208.08));
		
	}
	
}
