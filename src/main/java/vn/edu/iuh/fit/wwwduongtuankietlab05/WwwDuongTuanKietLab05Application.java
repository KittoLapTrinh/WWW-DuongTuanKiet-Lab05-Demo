package vn.edu.iuh.fit.wwwduongtuankietlab05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import vn.edu.iuh.fit.wwwduongtuankietlab05.models.Account;
import vn.edu.iuh.fit.wwwduongtuankietlab05.repositories.AccountRepository;

import java.util.Random;

@SpringBootApplication
public class WwwDuongTuanKietLab05Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WwwDuongTuanKietLab05Application.class, args);
    }

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Random rnd = new Random();
//        for(long i = 1; i< 100; i++){
//            Account account = new Account(i, "Name #" + i, rnd.nextDouble(100000d));
//            repository.save(account);
//        }
//        repository.findAll().forEach(System.out::println);

        PageRequest request = PageRequest.of(1, 5);

        repository.findByBalanceGreaterThan(50000, request)
                .forEach(System.out::println);

    }
}
