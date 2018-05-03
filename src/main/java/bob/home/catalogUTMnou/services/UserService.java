package bob.home.catalogUTMnou.services;

import bob.home.catalogUTMnou.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
