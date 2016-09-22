import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by azws on 2016-09-22.
 */

@SpringBootApplication
@ComponentScan(value = "com.gft")
@Configuration
public class Program {

    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }
}
