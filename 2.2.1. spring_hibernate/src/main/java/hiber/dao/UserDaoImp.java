package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      String hql = "SELECT u FROM User u JOIN FETCH u.usersCar";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      return query.getResultList();
   }

   @Override
   public User getUserCarByModelAndSeries(String model, int series) {
      String hql = "SELECT u FROM User u JOIN FETCH u.usersCar " +
              "WHERE u.usersCar.model = :model AND u.usersCar.series = :series";
      return sessionFactory.getCurrentSession()
              .createQuery(hql, User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .uniqueResult();
   }
}