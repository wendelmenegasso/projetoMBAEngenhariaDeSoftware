package br.com.mba.engenharia.de.software.negocio.account;

public enum TipoConta {
    CC(1, "Conta Corrente"),
    CP(2, "Conta Poupança"),
    CS(3, "Conta Salario"),
    CE(4, "Conta Empresarial");
    private final int chave;
    private final String valor;

    TipoConta(int chave, String valor){
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
