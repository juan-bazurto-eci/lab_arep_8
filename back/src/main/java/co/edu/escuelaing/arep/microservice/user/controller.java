package co.edu.escuelaing.arep.microservice.user;

import co.edu.escuelaing.arep.microservice.user.repository.MongoDbRepositoryUser;
import co.edu.escuelaing.arep.microservice.user.service.UserService;
import static spark.Spark.*;

public class controller {


    public static void main(String... args){
        MongoDbRepositoryUser mongoDbRepositoryUser = new MongoDbRepositoryUser();
        port(getPort());

        //User
        path("/user", () -> {
            UserService userService =  new UserService(mongoDbRepositoryUser);
            post("/auth", (req, res) -> {
                //verify if user exist
                return "ok";
            });
            get("/getall", (req, res) -> {
                return userService.getAllUsers();
            });
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 80;
    }


}
