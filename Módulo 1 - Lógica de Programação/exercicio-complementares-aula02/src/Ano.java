public enum Ano {
    JANEIRO (1000.00),
    FEVEREIRO (2000.00),
    MARÇO (3000.00),
    ABRIL (4000.00),
    MAIO (5000.00),
    JUNHO (6000.00),
    JULHO (7000.00),
    AGOSTO (8000.00),
    SETEMBRO (9000.00),
    OUTRUBO (10000.00),
    NOVEMBRO (11000.00),
    DEZEMBRO (12000.00);

    private double valor;
    Ano(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
