package br.com.mba.engenharia.de.software.negocio.account;

public enum Banco {
    BRADESCO(1, "1","Bradesco"),
    BB(2, "2", "Banco do Brasil"),
    C6(3,"3", "C6"),
    CAIXA(4,"4", "Caixa Economica Federal"),
    ITAU(5,"5", "Itau"),
    NUBANK(6,"6", "Nubank"),
    PAN(7,"7", "Banco PAN"),
    SANTANDER(8,"8", "Santander"),
    OUTROS(9,"9", "Outros");

    private final int chave;
    private final String valor;
    private final String desc;

    Banco(int chave, String valor, String desc){
        this.chave = chave;
        this.valor = valor;
        this.desc = desc;
    }
    public int busca(String valor){
        for (Banco banco : Banco.values()){
            if (banco.valor.equals(valor)){
                return banco.chave;
            }
        }
        return -1;
    }

}
