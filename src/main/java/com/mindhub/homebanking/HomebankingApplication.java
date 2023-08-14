package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository){
		return (args) -> {
			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Jorge", "Alvarez", "AlvarezJorge@gmail.com");
			clientRepository.save(client1);
			clientRepository.save(client2);

			Account account1 = new Account("VIN001", LocalDate.now(), 5000);
			Account account2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500);
			Account account3 = new Account("VIN003", LocalDate.now(), 10000);
			Account account4 = new Account("VIN004", LocalDate.now().minusDays(10), 4000);

			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);
			client2.addAccount(account4);
			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);

			Transaction transaction1 = new Transaction(TransactionType.DEBIT, -400, "mov01", LocalDate.now());
			Transaction transaction2 = new Transaction(TransactionType.CREDIT, 600, "mov02", LocalDate.now());
			Transaction transaction3 = new Transaction(TransactionType.CREDIT, 1200, "mov03", LocalDate.now());
			Transaction transaction4 = new Transaction(TransactionType.DEBIT, -100, "mov04", LocalDate.now());
			Transaction transaction5 = new Transaction(TransactionType.CREDIT, 3000, "mov05", LocalDate.now());
			Transaction transaction6 = new Transaction(TransactionType.DEBIT, -1000, "mov06", LocalDate.now());
			Transaction transaction7 = new Transaction(TransactionType.CREDIT, 5000, "mov07", LocalDate.now());
			Transaction transaction8 = new Transaction(TransactionType.DEBIT, -3000, "mov08", LocalDate.now());

			account1.addTransaction(transaction1);
			account1.addTransaction(transaction2);
			account2.addTransaction(transaction3);
			account2.addTransaction(transaction4);
			account3.addTransaction(transaction5);
			account3.addTransaction(transaction6);
			account4.addTransaction(transaction7);
			account4.addTransaction(transaction8);
			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);
			transactionRepository.save(transaction7);
			transactionRepository.save(transaction8);

			Loan loan1 = new Loan("Hipotecario", 500000, List.of(12,24,36,48,60));
			Loan loan2 = new Loan("Personal", 100000, List.of(6,12,24));
			Loan loan3 = new Loan("Automotriz", 500000, List.of(6,12,24,36));
			loanRepository.save(loan1);
			loanRepository.save(loan2);
			loanRepository.save(loan3);

			ClientLoan clientLoan1 = new ClientLoan(300000,60,client1, loan1);
			ClientLoan clientLoan2 = new ClientLoan(50000,12,client1, loan2);
			ClientLoan clientLoan3 = new ClientLoan(100000,24,client2, loan2);
			ClientLoan clientLoan4 = new ClientLoan(200000,36,client2, loan3);
			clientLoanRepository.save(clientLoan1);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			clientLoanRepository.save(clientLoan4);
			//clientLoanRepository.save(clientLoan2);
			//clientLoanRepository.save(clientLoan3);
			//clientLoanRepository.save(clientLoan4);

		};
	}
}
