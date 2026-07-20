package org.demo.testapp.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Because IntelliJ isn't that clever, we have to let the IDE know about
 * JPA Repos when we're running a DataJpaTest, so it can do the wiring
 */
@TestConfiguration
@EnableJpaRepositories(basePackages = "org.demo.testapp.repository")
public class JpaTestConfig {
}
