package pl.zulwik.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.zulwik.driver.property.FileStorageProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class DriverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriverApplication.class, args);
    }

}
