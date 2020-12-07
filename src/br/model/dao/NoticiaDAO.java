/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import br.connection.ConnectionFactory;
import br.model.bean.Noticia;

/**
 *
 * @author Computador
 */
public class NoticiaDAO {
     public void save(Noticia noticia) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if (noticia.getId() == -1) { //create
                em.persist(noticia);
            } else { //update
                em.merge(noticia);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Noticia remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Noticia noticia = null;
        try {
            noticia = em.find(Noticia.class, id);
            em.getTransaction().begin();
            em.remove(noticia);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return noticia;
    }

    public List<Noticia> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Noticia> noticias = null;
        try {
            noticias = em.createQuery("from Noticia n").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return noticias;
    }
    
    public List<Noticia> findAllByFilter(String filter, String filterValue) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Noticia> noticias = null;
        try {
            noticias = em.createQuery("SELECT n FROM Noticia n WHERE n." + filter + " LIKE '%" + filterValue + "%'")
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return noticias;
    }
}
