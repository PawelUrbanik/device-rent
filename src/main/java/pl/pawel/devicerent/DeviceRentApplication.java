package pl.pawel.devicerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.pawel.devicerent.model.Category;
import pl.pawel.devicerent.model.Client;
import pl.pawel.devicerent.model.Device;
import pl.pawel.devicerent.repository.CategoryRepository;
import pl.pawel.devicerent.repository.ClientRepository;
import pl.pawel.devicerent.repository.DeviceRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DeviceRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceRentApplication.class, args);
    }

}
