package br.com.mba.engenharia.de.software.service;

import br.com.mba.engenharia.de.software.PersistenceUnitInfoImpl;
import br.com.mba.engenharia.de.software.exceptions.ListarContaException;
import br.com.mba.engenharia.de.software.negocio.contas.Conta;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.persistenceunit.SmartPersistenceUnitInfo;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ContaService {

    @PersistenceContext
    jakarta.persistence.EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(ContaService.class);

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter hibernatePersistenceProvider = new HibernateJpaVendorAdapter();
        Properties properties = new Properties();
        properties.put("spring.jpa.database-platform", "org.hibernate.dialect.MySQL57Dialect");
        properties.put("spring.jpa.generate-ddl", true);
        properties.put("spring.datasource.url", "jdbc:mysql://root:fsa41306@localhost:3306/tcc?useTimezone=true&serverTimezone=UTC");
        properties.put("spring.datasource.username", "root");
        properties.put("spring.datasource.password", "fsa41306");
        properties.put("spring.jpa.hibernate.ddl-auto", "create");
        properties.put("spring.datasource.driver-class-name", "com.mysql.jdbc.Driver");
        properties.put("spring.main.allow-bean-definition-overriding", true);
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://root:fsa41306@localhost:3306/tcc?useTimezone=true&serverTimezone=UTC");

        List<String> managedClassName = new ArrayList<>();
        managedClassName.add("br.com.mba.engenharia.de.software.negocio.contas.Conta");
        SmartPersistenceUnitInfo pui = new PersistenceUnitInfoImpl("tcc", managedClassName, properties);
        pui.setPersistenceProviderPackageName("\"br.com.mba.engenharia.de.software.negocio.contas.Conta");
        this.entityManager = hibernatePersistenceProvider.getPersistenceProvider().createContainerEntityManagerFactory(pui, properties).createEntityManager();
        return hibernatePersistenceProvider.getPersistenceProvider().createContainerEntityManagerFactory(pui, properties);
    }

    public boolean salvarConta(Conta contas) {
        entityManagerFactory();
        entityManager.getTransaction().begin();
        List list = entityManager.createNativeQuery("select id from conta").getResultList();
        if (list.size() > 0) {
            int id = (int) list.get(list.size() - 1) + 1;
            contas.setId(id);
        } else {
            contas.setId(1);
        }
        try {
            entityManager.persist(contas);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            entityManager.close();
            logger.trace(String.format("Erro %s", exception));
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public List<Conta> procuraRegistro(List<Conta> list, Conta contas){
        List<Conta> listaDeResultados = new ArrayList<>();
        for (Conta conta : list){
            if (contas.getId() == null && contas.getConta().isEmpty() && contas.getAgencia().isEmpty()) {
                listaDeResultados = listarTodasContas();
            }
            else if (contas.getId() == null && !contas.getConta().isEmpty() && contas.getAgencia().isEmpty()) {
                if (conta.getConta().equals(contas.getConta())){
                    listaDeResultados.add(conta);
                }
            } else if (contas.getId() == null && contas.getConta().isEmpty() && !contas.getAgencia().isEmpty()) {
                if (conta.getAgencia().equals(contas.getAgencia())){
                    listaDeResultados.add(conta);
                }   }
            else {
                if (conta.getConta().equals(contas.getConta())){
                    listaDeResultados.add(conta);
                }    }
        }
        return listaDeResultados;
    }

    public List<Conta> listarConta(Conta contas){
        List<Conta> listaDeContas = listarTodasContas();
        return procuraRegistro(listaDeContas, contas);
    }

    public List<Conta> listarTodasContas() {
        entityManagerFactory();
        entityManager.getTransaction().begin();
        List<Conta> listaDeContas = new ArrayList<>();
        int posicao = 0;
        posicao = entityManager.createNativeQuery("select id from conta").getResultList().size();
        try {
            for (int i=1; i <= posicao; i++){
                listaDeContas.add(entityManager.find(Conta.class, i));
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            entityManager.close();
            logger.trace(String.format("Erro %s", exception));
            throw new ListarContaException("Erro na hora de listar as contas!");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return listaDeContas;
    }
}


