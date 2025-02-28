package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ContaCorrente contaCorrente = new ContaCorrente(12345, "Arthur", 5000, 5000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(24680, "Antonio", 15000);
        ContaInvestimento contaInvestimento = new ContaInvestimento(13579, "Rabelo", 20000);
        ContaSalario contaSalario = new ContaSalario(13468, "de", 2000, 5000);
        ContaInvestimentoAltoRisco contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco(98543, "Souza", 15000);

        System.out.println("\n");
        System.out.println("CONTA CORRENTE");
        contaCorrente.exibirInformacoes();
        contaCorrente.depositar(200);
        System.out.println("Saldo novo: " + contaCorrente.saldo);
        System.out.println(contaCorrente.sacar(2000)); //saque normal
        System.out.println(contaCorrente.sacar(7000)); //saque com cheque especial
        System.out.println(contaCorrente.sacar(50000)); //saque acima do limite
        System.out.println(contaCorrente.sacar(-1) + "\n\n"); //saque inválido

        System.out.println("CONTA POUPANÇA");
        contaPoupanca.exibirInformacoes();
        contaPoupanca.depositar(200);
        System.out.println("Saldo novo: " + contaPoupanca.saldo);
        System.out.println(contaPoupanca.sacar(2000)); //saque normal
        System.out.println(contaPoupanca.sacar(20000)); //saque acima do limite
        System.out.println(contaPoupanca.sacar(-1) + "\n\n"); //saque inválido

        System.out.println("CONTA INVESTIMENTO");
        contaInvestimento.exibirInformacoes();
        contaInvestimento.depositar(200);
        System.out.println("Saldo novo: " + contaInvestimento.saldo);
        System.out.println(contaInvestimento.sacar(10000)); //saque normal com porcentagem na operação
        System.out.println(contaInvestimento.sacar(25000) + "\n\n"); //saque inválido

        System.out.println("CONTA SALÁRIO");
        contaSalario.exibirInformacoes();
        contaSalario.depositar(200);
        System.out.println("Saldo novo: " + contaSalario.saldo);
        System.out.println(contaSalario.sacar(6000)); //saque gratuito
        System.out.println(contaSalario.sacar(5000)); //saque sem ser gratuito
        System.out.println(contaSalario.sacar(10000) + "\n\n"); //saque inválido

        System.out.println("CONTA INVESTIMENTO ALTO RISCO");
        contaInvestimentoAltoRisco.exibirInformacoes();
        contaInvestimentoAltoRisco.depositar(200);
        System.out.println("Saldo novo: " + contaInvestimentoAltoRisco.saldo);
        System.out.println(contaInvestimentoAltoRisco.sacar(15000)); //saque normal com porcentagem na operação
        System.out.println(contaInvestimentoAltoRisco.sacar(10000)); //saque inválido abaixo do mínimo
        System.out.println(contaInvestimentoAltoRisco.sacar(20000) + "\n\n"); //saque inválido acima do saldo
    }
}