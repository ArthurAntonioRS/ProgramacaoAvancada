package org.example;

public class ContaSalario extends ContaCorrente {
    int saqueGratuito = 1;

    public ContaSalario(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo, chequeEspecial);
        this.saldo = saldo;
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public double sacar(double valor) {
        if (valor <= saldo && valor > 0 && saqueGratuito > 0) {
            saqueGratuito--;
            saldo -= valor;
            System.out.print("Sacar: ");
        } else if (valor <= saldo + chequeEspecial && valor > 0 && saqueGratuito > 0) {
            saldo += chequeEspecial;
            saldo -= valor;
            saqueGratuito--;
            System.out.print("Sacar: ");
        } else if (valor > saldo + chequeEspecial) {
            System.out.print("O saldo mais o cheque especial foi excedido, valor digitado: R$ ");
        } else if (valor < 0) {
            System.out.print("O valor digitado é inválido: R$ ");
        } else if (valor <= saldo + chequeEspecial && valor > 0 && saqueGratuito <= 0) {
            saldo = (saldo + chequeEspecial) - valor;
            System.out.print("Sacar: ");
            return valor - 5;
        } else if (valor <= saldo && valor > 0 && saqueGratuito <= 0) {
            saldo = (saldo + chequeEspecial) - valor;
            System.out.print("Sacar: ");
            return valor - 5;
        }
        return valor;
    }


    // TESTE QUE NÃO DEU CERTO
    /*@Override
    public double sacar(double valor) {
        if (valor > 0 && saqueGratuito == 1 && valor <= saldo + chequeEspecial) {
            saqueGratuito--;
            saldo = (saldo + chequeEspecial) - valor;
            System.out.print("Sacar: ");
            return valor;
        } else if (valor > 0 && saqueGratuito <= 0 && valor <= saldo + chequeEspecial) {
            System.out.print("Sacar: ");
            saldo = (saldo + chequeEspecial) - valor;
            return valor - 5;
        } else if (valor > saldo + chequeEspecial) {
            System.out.print("O saldo mais o cheque especial foi excedido, valor digitado: R$ ");
            return valor;
        } else {
            System.out.print("O valor digitado é inválido: R$ ");
        }
        return valor;
    }*/


    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

}