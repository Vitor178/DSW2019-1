package br.ufscar.dc.dsw.dao;


import br.ufscar.dc.dsw.pojo.Teatro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeatroDAO extends GenericDAO<Teatro>{
    
    @Override
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Teatro l", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }
    
    public List<Teatro> getByCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT t FROM Teatro t WHERE t.cidade = :cidade";
        TypedQuery<Teatro> q = em.createQuery(sql, Teatro.class);
        q.setParameter("cidade", cidade);
        return q.getResultList();
    }
    
    public List<String> getCidades() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select distinct (l.cidade) from Teatro l", Teatro.class);
        List<String> cidades = q.getResultList();
        em.close();
        return cidades;
    }
    
    

    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getId());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
    
    @Override
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public Teatro get(Long id) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        return teatro;
    }
    
    public Teatro getByEmail(String email) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT e FROM Teatro e WHERE e.email = :email";
        TypedQuery<Teatro> q = em.createQuery(sql, Teatro.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }
}