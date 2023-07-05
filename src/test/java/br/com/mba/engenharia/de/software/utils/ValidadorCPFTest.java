package br.com.mba.engenharia.de.software.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidadorCPFTest {

    private ValidadorCPF validadorCPF;

    @Before
    public void setup(){
        validadorCPF = new ValidadorCPF();
    }

    @Test
    public void cpfValido(){
        String cpf = "32254802927";
        Assert.assertTrue(validadorCPF.isValid(cpf));
    }

    @Test
    public void cpfMaiorQueOTamanho(){
        String cpf = "32548029271";
        Assert.assertFalse(validadorCPF.isValid(cpf));
    }

    @Test
    public void cpfMenorQueOTamanho(){
        String cpf = "3225480292";
        Assert.assertFalse(validadorCPF.isValid(cpf));
    }

    @Test
    public void cpfInvalido(){
        String cpf = "11111111110";
        Assert.assertFalse(validadorCPF.isValid(cpf));
    }

}
