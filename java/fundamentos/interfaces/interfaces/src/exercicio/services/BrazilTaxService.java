package exercicio.services;

public class BrazilTaxService implements ITaxService{

    public Double tax(Double amount) {
        if(amount <= 100.0) {
            return amount * 0.2;
        }
        return amount * 0.15;
    }
}
