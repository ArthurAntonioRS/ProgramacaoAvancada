package org.example;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public double sacar(double valor) {
        if (valor <= saldo && valor >= 0) {
            saldo -= valor;
            System.out.print("Sacar: ");
        } else if (valor > saldo) {
            //valor = Double.parseDouble("Saldo insuficiente");
            System.out.print("Saldo insuficiente, valor digitado: R$ ");
        } else if (valor < 0) {
            System.out.print("O valor digitado é inválido: R$ ");
        }
        return valor;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
    }

}