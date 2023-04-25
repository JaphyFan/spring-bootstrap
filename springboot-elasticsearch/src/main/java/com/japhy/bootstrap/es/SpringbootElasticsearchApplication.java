package com.japhy.bootstrap.es;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * SpringbootElasticsearchApplication main class.
 *
 * @author japhy
 */
@SpringBootApplication
@EnableElasticsearchRepositories
@RequiredArgsConstructor
public class SpringbootElasticsearchApplication {


//    private final UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchApplication.class, "--debug");
    }

//    @Override
//    public void run(String... args) throws Exception {
//        User user = userService.saveUser(
//            User.builder().name("fanflskjdlkjfskljdlfksjdklfjslkdjflskjdflksjflkjskldjfslkdjfklsjdlfksjdlkfjslkdjfklsjdflksjdklfjslkdfjslkdjflksjdflsk"
//                + "jdjlfjskdjflksjdlkfjslkjdflksjdlfkjslkfjlskjdflksjldkfjslkjdflksjdlfkjslkdjflskjdlfkjsldkjflskjdlkfjlsjflksjdlkfjslkdjflksjdfklsjlh").time(LocalDateTime.now()).updateTime(LocalDateTime.now())
//                .formattedTime(new Date()).test1(LocalDateTime.now()).test3(LocalDateTime.now())
//                .test4(ZonedDateTime.now()).flattenedBank(
//                Bank.builder().accountNumber(1).address("hangzhou changxing").build())
//                .bank(Bank.builder().accountNumber(22222).address("hangzhou huzhou").build())
//                .build());
//
//        Optional<User> byUser = userService.findByUser(user.getId());
//        byUser.ifPresent(System.out::println);
//        SearchHits<User> searchHits = userService.queryAllUsers();
//    }
}
