package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional(readOnly = false)
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
    @Transactional(readOnly = false)
    public void saveNewUser(User user) {
        userDao.saveNewUser(user);
    }
    @Transactional(readOnly = false)
    public void updateUserById(int id, User updatedUser) { userDao.updateUserById(id, updatedUser);}
    public User getUserById(int id) {
       return userDao.getUserById(id);
    }
}
