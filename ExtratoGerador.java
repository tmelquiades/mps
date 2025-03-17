
/*
dip:
ExtratoGerador depende de Client e Rent, mas somente atraves de abstracoes, garantindo baixo acoplamento
*/
class ExtratoGerador {
    public String gerarExtrato(Client cliente) {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        StringBuilder resultado = new StringBuilder();
        
        resultado.append("Registro de Alugueis de ").append(cliente.getNome()).append(fimDeLinha);
        
        for (Rent rent : cliente.getTapesAlugadas()) {
            double valorCorrente = rent.calcularValor();
            pontosDeAlugadorFrequente += rent.calcularPontos();
            
            resultado.append("\t").append(rent.getTape().getTitulo()).append("\t").append(valorCorrente).append(fimDeLinha);
            valorTotal += valorCorrente;
        }
        
        resultado.append("Valor total devido: ").append(valorTotal).append(fimDeLinha);
        resultado.append("Voce acumulou ").append(pontosDeAlugadorFrequente).append(" pontos de alugador frequente");
        
        return resultado.toString();
    }
}