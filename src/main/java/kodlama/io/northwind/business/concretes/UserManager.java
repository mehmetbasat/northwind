package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.dataAccess.UserDao;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public DataResult<User> findByEmailName(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email), "User finded");
    }
}
