package net.jfuentestgn.enslocals;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.spring.tx.annotation.Transactional;
import net.jfuentestgn.enslocals.domain.EnsLocalEntity;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//@Singleton
public class EnsLocalRepositoryImpl /*implements EnsLocalRepository*/ {

//    @PersistenceContext
//    private EntityManager entityManager;
//    private final ApplicationConfiguration applicationConfiguration;
//
//    public EnsLocalRepositoryImpl(@CurrentSession EntityManager entityManager,
//                               ApplicationConfiguration applicationConfiguration) {
//        this.entityManager = entityManager;
//        this.applicationConfiguration = applicationConfiguration;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<EnsLocalEntity> findAll() {
//        String qlString = "SELECT e FROM EnsLocalEntity as e";
//        TypedQuery<EnsLocalEntity> query = entityManager.createQuery(qlString, EnsLocalEntity.class);
//        return query.getResultList();
//    }
//
//    @Override
//    @Transactional
//    public EnsLocalEntity save(EnsLocalEntity ensLocal) {
//        entityManager.persist(ensLocal);
//        return ensLocal;
//    }
}
