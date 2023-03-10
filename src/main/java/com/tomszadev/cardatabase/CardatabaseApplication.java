package com.tomszadev.cardatabase;

import com.tomszadev.cardatabase.domain.Car;
import com.tomszadev.cardatabase.domain.User;
import com.tomszadev.cardatabase.repository.CarRepoPageAndSort;
import com.tomszadev.cardatabase.repository.CarRepository;
import com.tomszadev.cardatabase.domain.Owner;
import com.tomszadev.cardatabase.repository.OwnerRepository;
import com.tomszadev.cardatabase.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CarRepoPageAndSort carRepoPageAndSort;

    public static void main(String[] args) {

        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner("Michel", "Jackson");
        Owner owner2 = new Owner("Elwis", "Presley");
        Owner owner3 = new Owner("Lois", "Lane");

        ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));

        Car car1 = new Car("Ford", "Mustang", "Red", "ADF-2189", 2021, 59000, owner1);
        Car car2 = new Car("Toyota", "Prius", "White", "OF-9254", 2000, 79099, owner2);
        Car car3 = new Car("BMW", "Z1", "Black", "Bi-8888", 2022, 99888, owner2);
        Car car4 = new Car("Seat", "Cordoba", "Orange", "RGF-7785", 1999, 99888, owner2);
        Car car5 = new Car("Skoda", "Octavia", "Green", "Wd-25986", 1968, 54_489, owner1);
        Car car6 = new Car("Renault", "Megane", "Gray", "kre-66666", 1985, 111111, owner3);
        carRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6));

        logger.info("CarDataBase-Application started now...");

        for (Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " -- " + car.getModel());
        }
        userRepository.save(new User("user","$2a$10$9vKEZyd1f0Sn5D.LTpzSQOM5UoQQJlabaNAbz1Zyl5bL4HDF07T0O", "USER"));
        userRepository.save(new User("admin","$2a$10$x/XiayEE1p5tyr4Ooz3dJOOkDlFkyxjpseMyaVyeFD/JN9MvUUK9u", "ADMIN"));

        logger.info("Current cars in databes = " + carRepository.count());

        System.out.println(("------ " + carRepository.findByBrand("Ford").toString() + "------"));
        System.out.println(("------ "+ ownerRepository.findOwnersByFirstname("Michel") + "------"));
        System.out.println(("------ "+ carRepoPageAndSort.findCarByColorContainingIgnoreCase("a") + "------"));
    }
}
