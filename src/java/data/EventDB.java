/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import business.Event;
import java.io.Serializable;
import java.util.Collections;

/**
 * 
 * @author William Reithmeyer
 */
public class EventDB implements Serializable{
    
    public static void insert(Event event) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(event);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static void update(Event event) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(event);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static void delete(Event event) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(event));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static boolean exists(int id) {
        Event p = selectEvent(id);
        return p != null;
    }
    public static boolean exists(String id) {
        Event p = selectEvent(id);
        return p != null;
    }

    public static Event selectEvent(String id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Event p " +
                "WHERE p.id = :id";
        TypedQuery<Event> q = em.createQuery(qString, Event.class);
        q.setParameter("id", id);
        Event result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return (Event)result;
    }
    public static Event selectEvent(int eventId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        return em.find(Event.class, eventId);
    }
    
    public static List<Event> selectEvents() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Event p";
        TypedQuery<Event> q = em.createQuery(qString, Event.class);
        List<Event> results = null;
        try {
            results = q.getResultList();
        } catch (Error ex) {
            System.out.println("error no list");
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
    public static List<Event> reverseEvents(){
        List<Event> clone = selectEvents();
        Collections.reverse(clone);
        return clone;
    }
}
