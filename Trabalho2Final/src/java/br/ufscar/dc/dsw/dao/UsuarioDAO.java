package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class UsuarioDAO extends GenericDAO<Usuario>{
    
    
    @Override
    public void save(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select u from Usuario u", Usuario.class);
        List<Usuario> usuarios = q.getResultList();
        em.close();
        return usuarios;
    }
    

    @Override
    public void delete(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Usuario.class, usuario.getId());
        tx.begin();
        em.remove(usuario);
        tx.commit();
    }
    
    @Override
    public void update(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }

    @Override
    public Usuario get(Long id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
    
    public Usuario getByEmail(String email) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByEmail", Usuario.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }
}
