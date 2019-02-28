package factorys;

import repositories.UserRepository;
import repositories.UserRepositoryHibernateImpl;

class HibernateFactory implements AbstractFactory{

    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryHibernateImpl();
    }
}
