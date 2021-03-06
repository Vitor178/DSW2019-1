package br.ufscar.dc.dsw.dao;


import br.ufscar.dc.dsw.pojo.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class SiteDAO extends GenericDAO<Site>{
    
    @Override
    public void save(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Site> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Site l", Site.class);
        List<Site> sites = q.getResultList();
        em.close();
        return sites;
    }

    @Override
    public void delete(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(Site.class, site.getId());
        tx.begin();
        em.remove(site);
        tx.commit();
    }
    
    @Override
    public void update(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }

    @Override
    public Site get(Long id) {
        EntityManager em = this.getEntityManager();
        Site site = em.find(Site.class, id);
        em.close();
        return site;
    }
    
    public Site getByNome(String nome) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT e FROM Site e WHERE e.nome = :nome";
        TypedQuery<Site> q = em.createQuery(sql, Site.class);
        q.setParameter("nome", nome);
        return q.getSingleResult();
    }
    
    public Site getByEmail(String email) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT e FROM Site e WHERE e.email = :email";
        TypedQuery<Site> q = em.createQuery(sql, Site.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }
    
  
}