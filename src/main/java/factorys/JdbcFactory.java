package factorys;

import repositories.UserRepository;
import repositories.UserRepositoryJdbcImpl;

class JdbcFactory implements AbstractFactory{

    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryJdbcImpl();
    }
}
