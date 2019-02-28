package factorys;

import repositories.PassportRepository;
import repositories.UserRepository;

public interface AbstractFactory {
    UserRepository getUserRepository();
}
