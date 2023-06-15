package br.com.mba.engenharia.de.software;

import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.security.GerarToken;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.persistenceunit.SmartPersistenceUnitInfo;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UsuarioTeste {

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter hibernatePersistenceProvider= new HibernateJpaVendorAdapter();
        Properties properties = new Properties();
        properties.put("spring.jpa.database-platform","org.hibernate.dialect.MySQL5Dialect");
        properties.put("spring.jpa.generate-ddl", true);
        properties.put("spring.datasource.url", "jdbc:mysql://root:fsa41306@localhost:3306/tcc");
        properties.put("spring.datasource.username","root");
        properties.put("spring.datasource.password","fsa41306");
        properties.put("spring.jpa.hibernate.ddl-auto","create");
        properties.put("spring.datasource.driver-class-name","com.mysql.cj.jdbc.Driver");
        properties.put("spring.main.allow-bean-definition-overriding",true);
        properties.put("javax.persistence.jdbc.url","jdbc:mysql://root:fsa41306@localhost:3306/tcc");

        Map<String, Usuario> map = new HashMap<>();
        GerarToken gerarToken = new GerarToken();
        Usuario u1 = new Usuario(2L,"java01@email.com", "teste1","java01@email.com", gerarToken.gerarToken());
        Usuario u2 = new Usuario(3L,"java02@email.com", "teste2", "java02@email.com", gerarToken.gerarToken());
        Usuario u3 = new Usuario(4L,"java03@email.com", "teste3", "java03@email.com", gerarToken.gerarToken());
        Usuario u4 = new Usuario(5L,"java04@email.com", "teste4", "java04@email.com", gerarToken.gerarToken());
        map.put("usuario1", u1);
        map.put("usuario2", u2);
        map.put("usuario3", u3);
        map.put("usuario4",u4);

        List<String> managedClassName = new ArrayList<>();
        managedClassName.add("Usuario");
        SmartPersistenceUnitInfo pui = new PersistenceUnitInfoImpl("usuario", managedClassName, properties);
        pui.setPersistenceProviderPackageName("test");

        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider.getPersistenceProvider().createContainerEntityManagerFactory(pui, properties);
        return entityManagerFactory;
    }

    public void salvarLista(){
        EntityManagerFactory entityManagerFactory = entityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();
        GerarToken gerarToken = new GerarToken();
        Usuario u1 = new Usuario(2L,"java01@email.com", "teste1","java01@email.com", gerarToken.gerarToken());
        Usuario u2 = new Usuario(3L,"java02@email.com", "teste2", "java02@email.com", gerarToken.gerarToken());
        Usuario u3 = new Usuario(4L,"java03@email.com", "teste3", "java03@email.com", gerarToken.gerarToken());
        Usuario u4 = new Usuario(5L,"java04@email.com", "teste4", "java04@email.com", gerarToken.gerarToken());
        entityManager.persist(u1);
        entityManager.persist(u2);
        entityManager.persist(u3);
        entityManager.persist(u4);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}


