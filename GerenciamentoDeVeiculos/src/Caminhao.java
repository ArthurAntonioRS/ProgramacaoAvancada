class Caminhao extends Veiculo {
    private double capacidadeCarga; // Em toneladas

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, "Diesel");
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        double reducao = Math.min(0.25, capacidadeCarga * 0.01); // Máximo de 25% de redução
        double consumo = 6 * (1 - reducao);
        return 300 * consumo; // 300 litros, consumo ajustado
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
    }
}