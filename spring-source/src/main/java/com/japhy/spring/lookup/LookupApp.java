package com.japhy.spring.lookup;

import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * 类似下面这种，当单例希望获取原型bean时，可以使用lookup-method.
 *
 * <pre class="code">
 * &#064;Component
 * public class SingoletonBean {
 *
 *     &#064;Autowired
 *     private PrototypeBean prototypeBean;
 *
 * }</pre>
 *
 * @author Japhy
 * @since 2023/4/20 00:03
 */
@Configuration
public class LookupApp {

    /**
     * CommandManger是单例的
     */
    @Component
    public class CommandManager {
        public void hello() {
            Command command = newCommand();
            command.hello();
        }

        @Lookup
        public Command newCommand() {
            throw new RuntimeException("newCommand() should not be called");
        }

    }

    @Component
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public class Command {

        private final String name;
        public Command(Optional<String> nameOptional) {
            Random random = new Random();
            name = nameOptional.orElse(String.valueOf(random.nextInt(100)));
        }

        public void hello() {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LookupApp.class);
        CommandManager bean = context.getBean(CommandManager.class);
        bean.hello();
        bean.hello();
    }

}
