package com.mright.test;

import io.micrometer.core.instrument.util.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public RedissonClient getRedissonClient() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress("192.168.120.142")
//                .setMasterName(redssionProperties.getMasterName())
                .setTimeout(3000)
                .setMasterConnectionPoolSize(1)
                .setSlaveConnectionPoolSize(2)
                .setPassword("123456")
                .setDatabase(1);

        return Redisson.create(config);
    }
}
