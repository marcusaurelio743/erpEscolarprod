package erpEscolar.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class DaoGenerico<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// O WildFly injeta a conexão automaticamente a partir do standalone.xml
    @PersistenceContext(unitName = "erpEscolar")
    private EntityManager entityManager;
    @Transactional
    public void salvar(E e) {
        // Não precisa de transaction.begin() nem commit()!
        entityManager.persist(e);
        // Não precisa fechar! O WildFly fecha ao terminar a requisição.
    }
    @Transactional
    public E merge(E e) {
        return entityManager.merge(e);
    }
    @Transactional
    public void delete(E e) {
        // No WildFly/JPA, a remoção é feita nativamente pelo repositório sem Query crua
        E objetoParaRemover = entityManager.merge(e);
        entityManager.remove(objetoParaRemover);
    }
    @Transactional
    @SuppressWarnings("unchecked")
    public List<E> findAll(Class<E> entidade) {
        return entityManager.createQuery("from " + entidade.getName()).getResultList();
    }

    // Caso precise fazer consultas personalizadas nas classes filhas
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
