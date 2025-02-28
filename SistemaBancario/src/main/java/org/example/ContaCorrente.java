package org.example;

public class ContaCorrente extends ContaBancaria {
    double chequeEspecial;

    public ContaCorrente(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public double sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            saldo -= valor;
            System.out.print("Saque normal: R$ ");
        } else if (valor <= saldo + chequeEspecial && valor > 0) {
            saldo = (saldo + chequeEspecial) - valor;
            System.out.print("Saque com cheque especial: R$ ");
        } else if (valor > saldo + chequeEspecial) {
            System.out.print("O saldo mais o cheque especial foi excedido, valor digitado: R$ ");
        } else if (valor < 0) {
            System.out.print("O valor digitado é inválido: R$ ");
        }
        return valor;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
    }

}