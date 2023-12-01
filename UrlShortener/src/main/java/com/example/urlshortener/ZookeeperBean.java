package com.example.urlshortener;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;

@Configuration
public class ZookeeperBean {

    @Value("${zookeeper.connectionPath}")
    private @NotNull String connectionPath;

    @Value("${zookeeper.sessionTimeout}")
    private int sessionTimeout; // 3000

    @Bean
    @Primary
    @NotNull
    public ZooKeeper getZookeeperClient() throws IOException {
        return new ZooKeeper(connectionPath, sessionTimeout, new Watcher() {
            @Override
            public void process(@NotNull WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        });
    }
}
