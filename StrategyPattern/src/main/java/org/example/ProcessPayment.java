package org.example;

public class ProcessPayment {

        private PaymentStrategy paymentStrategy;

        public ProcessPayment(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.ProcessPayment(amount);
        }
}
