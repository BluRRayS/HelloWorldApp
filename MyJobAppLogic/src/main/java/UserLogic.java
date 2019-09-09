import com.blurrays.myjobappdata.ContextInterfaces.IUserSqlContext;
import com.blurrays.myjobappdata.User.UserRepository;
import com.blurrays.myjobappinterfaces.IUser;
import com.blurrays.myjobapplogic.Models.User;

import Helpers.Encryption;

public class UserLogic {
    private UserRepository repository;

    UserLogic(IUserSqlContext context) {
        repository = new UserRepository(context);
    }

    public void createUser(IUser user) {
        Encryption encryption = new Encryption();
        user.setPassword(encryption.hash(user.getPassword()+encryption.getSalt()));
        repository.createUser(user);
    }

    public boolean credentialsMatch(String email, String password) {
        Encryption encryption = new Encryption();
        return repository.credentialsMatch(email, encryption.hash(password + repository.getUserSalt(email)));
    }

    public boolean isEmailTaken(String email) {
        return repository.isEmailTaken(email);
    }

    public IUser getUserById(int id) {
        return repository.getUserById(id);
    }

    public void updateUser(IUser user) {
        Encryption encryption = new Encryption();
        user.setPassword(encryption.hash(user.getPassword()));
        repository.updateUser(user);

    }

}
