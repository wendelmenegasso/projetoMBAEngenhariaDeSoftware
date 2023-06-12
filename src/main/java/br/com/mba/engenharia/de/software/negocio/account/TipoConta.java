package br.com.mba.engenharia.de.software.negocio.account;

public enum TipoConta {
    CC(1, "1", "Conta Corrente"),
    CP(2, "2", "Poupança"),
    CS(3, "3", "Conta Salario"),
    CE(4, "4", "Conta Empresarial");
    private final int chave;
    private final String valor;
    private final String desc;

    TipoConta(int chave, String valor, String desc){
        this.chave = chave;
        this.valor = valor;
        this.desc = desc;
    }

    public int busca(String valor){
        for (TipoConta tipo : TipoConta.values()){
            if (tipo.valor.equals(valor)){
                return tipo.chave;
            }
        }
        return -1;
    }
}
