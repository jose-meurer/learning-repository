package exercicio2.services;

import exercicio2.entities.Contract;
import exercicio2.entities.Installment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContractService {

    private IOnlinePaymentService paymentService;

    public ContractService(IOnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {

        double installmentValue = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate date = contract.getDate().plusMonths(i);

            double interest = paymentService.interest(installmentValue, i);
            double tax = paymentService.paymentFree(installmentValue + interest);
            double totalPayment = installmentValue + interest + tax;

            contract.getInstallments().add(new Installment(date, totalPayment));
        }
    }
}
