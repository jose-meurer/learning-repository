package exercicio2.services;

public interface IOnlinePaymentService {

    Double paymentFree(Double amount);

    Double interest(Double amount, Integer months);
}
