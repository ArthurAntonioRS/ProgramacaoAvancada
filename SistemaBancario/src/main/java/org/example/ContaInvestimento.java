package org.example;

public class ContaInvestimento extends ContaBancaria {

    public ContaInvestimento(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public double sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            valor = valor * 0.98;
            saldo -= valor;
            System.out.print("Sacar: ");
        } else {
            System.out.print("O valor digitado é inválido: R$ ");
        }
        return valor;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
    }

}