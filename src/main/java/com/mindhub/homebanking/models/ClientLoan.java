package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class ClientLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private double amount;
    private int payments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="clientLoan_id")
    private Client clientLoan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loan_id")
    private Loan loan;

    public ClientLoan(){

    }

    public ClientLoan(double amount, int payments, Client clientLoan, Loan loan) {
        this.amount = amount;
        this.payments = payments;
        this.clientLoan = clientLoan;
        this.loan = loan;
    }

    public ClientLoan(Client clientLoan, Loan loan){
        this.clientLoan = clientLoan;
        this.loan = loan;

    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public Client getClientLoan() {
        return clientLoan;
    }

    public void setClientLoan(Client clientLoan) {
        this.clientLoan = clientLoan;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }


}
