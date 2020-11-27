package com.sammidev.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.sammidev.entity"})
@EnableJpaRepositories(basePackages = {"com.sammidev.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
