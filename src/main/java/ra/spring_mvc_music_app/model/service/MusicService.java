package ra.spring_mvc_music_app.model.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ra.spring_mvc_music_app.model.entity.Music;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Music> findAll() {
        List<Music> list = new ArrayList<>();
        String hql = "select singer from Music m";
        TypedQuery<Music> query = entityManager.createQuery(hql, Music.class);
        list = query.getResultList();
        return  list;
    }

    @Override
    public Music findById(Long id) {
        String hql ="Select s from Music as s where s.id= :id";
        TypedQuery<Music> query = entityManager.createQuery(hql, Music.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void save(Music s) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(s);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Music s) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music music = findById((long) s.getId());
            music.cloneMusic(s);
            session.update(music);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
