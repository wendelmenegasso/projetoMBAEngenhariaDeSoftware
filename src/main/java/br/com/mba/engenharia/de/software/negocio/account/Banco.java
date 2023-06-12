package br.com.mba.engenharia.de.software.negocio.account;

public enum Banco {
    BRADESCO(1, "Bradesco"),
    BB(2, "Banco do Brasil"),
    C6(3, "C6"),
    CAIXA(4, "Caixa Economica Federal"),
    ITAU(5, "Itau"),
    NUBANK(6, "Nubank"),
    PAN(7, "Banco PAN"),
    SANTANDER(8, "Santander"),
    OUTROS(9, "Outros");

    private final int chave;
    private final String valor;

    Banco(int chave, String valor){
        this.chave = chave;
        this.valor = valor;
    }
    public String getValor(){
        return this.valor;
    }
    public int getChave(){
        return  this.chave;
    }

}
