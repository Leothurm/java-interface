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
		
		
		double basicQuota = contract.getTotalValue()/months;
		
		for(int i = 1; i <= months;i++) {
			//forma de adicionar somar meses
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(basicQuota, i) ;
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double parcela = basicQuota + interest + fee;
			
			contract.getInstallment().add(new Installment(dueDate,parcela));
			
			
		}
		
		
		
		
	}
	
}
