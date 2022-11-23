package com.aupma.postgresstenant.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.aupma.postgresstenant")
@EnableJpaRepositories("com.aupma.postgresstenant")
@EnableTransactionManagement
public class DomainConfig {
}
