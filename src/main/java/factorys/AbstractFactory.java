package factorys;

import repositories.UserRepository;

public interface AbstractFactory {
    UserRepository createUserRepository();
}
