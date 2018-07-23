package fi.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityListeners;

@SpringBootApplication
@EnableJpaAuditing
public class TurntikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurntikiApplication.class, args);
    }

}
