package co.edu.escuelaing.arep.microservice.user.service;


import co.edu.escuelaing.arep.microservice.user.entity.User;
import co.edu.escuelaing.arep.microservice.user.repository.MongoDbRepositoryUser;
import java.util.ArrayList;

public class UserService {
    private final MongoDbRepositoryUser mongoDbRepository;

    public UserService(MongoDbRepositoryUser mongoDbRepositoryUser) {
        this.mongoDbRepository = mongoDbRepositoryUser;
        this.mongoDbRepository.createConnection("userdb","users");
    }


    public ArrayList<User> getAllUsers(){
        return mongoDbRepository.getAllUsers();
    }
}
