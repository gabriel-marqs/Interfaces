package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.service.ContractService;
import entities.service.PagSeguroService;
import entities.service.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter the contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.print("Enter the number of installments: ");
		int months = sc.nextInt();

		ContractService cs = new ContractService(new PayPalService());

		cs.processContract(contract, months);

		System.out.println();
		System.out.println("Installments (PayPal):");
		for (Installment installment : contract.getInstalmments()) {
			System.out.println(installment.getDueDate().format(fmt) + " - " + installment.getAmount());
		}

		cs = new ContractService(new PagSeguroService());

		cs.processContract(contract, months);
		
		System.out.println();
		System.out.println("Installments (PagSeguro):");
		for (Installment installment : contract.getInstalmments()) {
			System.out.println(installment.getDueDate().format(fmt) + " - " + installment.getAmount());
		}

		sc.close();
	}

}
