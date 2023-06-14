package br.com.mba.engenharia.de.software;

import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.security.GerarToken;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UsuarioTeste {

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernatePersistenceProvider springHibernateJpaPersistenceProvider = new HibernatePersistenceProvider();
        Map properties = new HashMap();
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) springHibernateJpaPersistenceProvider.createEntityManagerFactory("test", properties);
        return entityManagerFactory;
    }

    public void salvarLista(){
        EntityManagerFactory entityManagerFactory = entityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        GerarToken gerarToken = new GerarToken();
        Usuario u1 = new Usuario(2L,"java01@email.com", "teste1","java01@email.com", gerarToken.gerarToken());
        Usuario u2 = new Usuario(3L,"java02@email.com", "teste2", "java02@email.com", gerarToken.gerarToken());
        Usuario u3 = new Usuario(4L,"java03@email.com", "teste3", "java03@email.com", gerarToken.gerarToken());
        Usuario u4 = new Usuario(5L,"java04@email.com", "teste4", "java04@email.com", gerarToken.gerarToken());
        usuarios.add(u1); usuarios.add(u2); usuarios.add(u3); usuarios.add(u4);
        entityManager.persist(usuarios);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}


