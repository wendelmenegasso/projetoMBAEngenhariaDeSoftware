package br.com.mba.engenharia.de.software;

import br.com.mba.engenharia.de.software.exceptions.ListarContaException;
import br.com.mba.engenharia.de.software.negocio.contas.Conta;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.persistenceunit.SmartPersistenceUnitInfo;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class UsuarioTeste {

    @PersistenceContext
    jakarta.persistence.EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioTeste.class);

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
        if (list.size() > 0){
            int id = (int) list.get(list.size() -1) + 1;
            contas.setId(id);
        }
        else{
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
    public List<Conta> listarTodasContas(Conta contas){
        entityManagerFactory();
        entityManager.getTransaction().begin();
        List<Conta> listaDeContas = new ArrayList<>();
        try {
            int tamanho = 0;
            tamanho = entityManager.createNativeQuery("select * from conta").getResultList().size();
            for (int i=1; i <= tamanho; i++){
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


