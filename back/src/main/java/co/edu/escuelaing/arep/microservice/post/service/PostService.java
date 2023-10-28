package co.edu.escuelaing.arep.microservice.post.service;

import co.edu.escuelaing.arep.microservice.post.entity.Post;
import co.edu.escuelaing.arep.microservice.post.repository.MongoDbRepositoryPost;

import java.util.List;

public class PostService{

    private final MongoDbRepositoryPost mongoDbRepository;

    public PostService(MongoDbRepositoryPost mongoDbRepository) {
        this.mongoDbRepository = mongoDbRepository;
        this.mongoDbRepository.createConnection("postdb","posts");
    }


    public void addPost(Post post){
        mongoDbRepository.addPost(post);
    }

    public List<String> getAllPost(){
        return mongoDbRepository.getAllDocuments();
    }
}
