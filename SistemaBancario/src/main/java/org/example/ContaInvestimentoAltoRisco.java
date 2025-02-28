package org.example;

public class ContaInvestimentoAltoRisco extends ContaInvestimento {
    public ContaInvestimentoAltoRisco(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public double sacar(double valor) {
        if (valor >= 10000 && valor <= saldo && valor > 0) {
            valor = valor * 0.95;
            saldo -= valor;
            System.out.print("Sacar: R$ ");
        } else if (valor < 10000){
            System.out.print("Valor a baixo do mínimo, você solicitou: R$ ");
        } else {
            System.out.print("O valor digitado é inválido: R$ ");
        }
        return valor;
    }

}