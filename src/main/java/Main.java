import com.rubens.apis.OmdbApi;
import com.rubens.configs.EnvConfig;
import com.rubens.daos.MovieDAO;
import com.rubens.database.DatabaseConnection;
import com.rubens.database.MySQLConnection;
import com.rubens.services.MoviesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection database = new MySQLConnection();
        var connection = database.connect();

        Scanner prompt = new Scanner(System.in);
        System.out.println("Type the movie´s title: ");

        var input = prompt.nextLine();

        try {
            MoviesService movies = new MoviesService();
            movies.demo(input, connection);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
