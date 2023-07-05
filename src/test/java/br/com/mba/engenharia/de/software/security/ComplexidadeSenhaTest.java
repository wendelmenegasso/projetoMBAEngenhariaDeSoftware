package br.com.mba.engenharia.de.software.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComplexidadeSenhaTest {
    private ComplexidadeSenha complexidadeSenha;

    @Before
    public void setup(){
        complexidadeSenha = new ComplexidadeSenha();
    }

    @Test
    public void senhaValida(){
        String senha1 = "Abcde_123456@";
        Assert.assertTrue(complexidadeSenha.isStronger(senha1));
        String senha2 = "@@123Abcd_675";
        Assert.assertTrue(complexidadeSenha.isStronger(senha2));
    }

    @Test
    public void senhaMenorQueOLimite(){
        String senha1 = "Abcd123@";
        Assert.assertFalse(complexidadeSenha.isStronger(senha1));
    }

    @Test
    public void senhaMaiorQueOLimite(){
        String senha1 = "Abcdefg@12345678_Fghijk-9101112131415";
        Assert.assertFalse(complexidadeSenha.isStronger(senha1));
    }

    @Test
    public void senhaSemCaracteresEspeciais(){
        String senha1 = "12345678Abcdefgh";
        Assert.assertFalse(complexidadeSenha.isStronger(senha1));
    }

    @Test
    public void senhaSemNumeros(){
        String senha1 = "Abcdefghi@abcdefghijk";
        Assert.assertFalse(complexidadeSenha.isStronger(senha1));
    }

    @Test
    public void senhaSemLetraMaiuscula(){
        String senha1 = "abcdefghijk_12345678";
        Assert.assertFalse(complexidadeSenha.isStronger(senha1));
    }
}
