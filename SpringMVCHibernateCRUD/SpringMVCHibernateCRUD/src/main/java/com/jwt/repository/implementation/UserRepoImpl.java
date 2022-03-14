package com.jwt.repository.implementation;


import com.jwt.dao.UserDao;
import com.jwt.dao.implementation.RoleDaoImpl;
import com.jwt.dao.implementation.UsersDaoImpl;
import com.jwt.model.Role;
import com.jwt.model.Users;
import com.jwt.repository.UserRepo;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {
    
    @Autowired
    UserDao userDao ;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserRepo userRepo;

    @Override
    public int login(String Email, String Password) {

           Users user = userRepo.findByEmail(Email);


        if(user.getEmail() == null){return 0;}
        System.out.println(user.getPassword().equals(Password));
        System.out.println(Password);
        return  (user.getPassword().equals(Password)) ? 1 : 2;
    }

    @Override
    public void logout() {

    }

    @Override
    public boolean updatePasswordById(String newPassword, long user_id) {
        Users userUpdated =   userDao.find(user_id);

        userUpdated.setPassword(newPassword);

       userDao.update(userUpdated);
        return true;
    }

    @Override
    public Users find(long id) {
        return userDao.find(id);
    }

    @Override
    public Users findByEmail(String Email) {

        System.out.println("je suis a findByemail");

        Query<Users>  query = sessionFactory.getCurrentSession().createQuery("from Users where email =:email",Users.class);
        query.setParameter("email", Email);

       Users user = query.getSingleResult();

        System.out.println(user);

        return user;
    }

    @Override
    public List<Users> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public Users add(Users user) {
        return userDao.add(user);

    }

    @Override
    @Transactional
    public Users update(Users user) {
        if(user.getRole().getName() == null){
          Role role = new RoleDaoImpl().find(user.getRole().getId_role()) ;
          user.setRole(role);
        }
        return userDao.update(user);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return userDao.delete(id);
    }
}
