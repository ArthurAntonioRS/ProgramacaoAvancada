public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 5, "Sedan");
        Caminhao caminhao = new Caminhao("Volvo", "FH16", 2021, 2, 5);
        Onibus onibus = new Onibus("Mercedes", "Busscar", 2020, 40, 6);
        CarroEletrico carroEletrico = new CarroEletrico("Tesla", "Model S", 2023, 5, "Sedan", 100);
        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R500", 2022, 2, 10, -18);

        System.out.println("\nDetalhes dos veículos e suas autonomias:\n");
        System.out.println("CARRO");
        carro.exibirDetalhes();
        System.out.println("Autonomia: " + carro.calcularAutonomia() + " km\n\n");

        System.out.println("CAMINHÃO");
        caminhao.exibirDetalhes();
        System.out.println("Autonomia: " + caminhao.calcularAutonomia() + " km\n\n");

        System.out.println("ÔNIBUS");
        onibus.exibirDetalhes();
        System.out.println("Autonomia: " + onibus.calcularAutonomia() + " km\n\n");

        System.out.println("CARRO ELÉTRICO");
        carroEletrico.exibirDetalhes();
        System.out.println("Autonomia: " + carroEletrico.calcularAutonomia() + " km\n\n");

        System.out.println("CAMINHÃO REFRIGERADO");
        caminhaoRefrigerado.exibirDetalhes();
        System.out.println("Autonomia: " + caminhaoRefrigerado.calcularAutonomia() + " km\n");
    }
}