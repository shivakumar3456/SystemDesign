package com.example.urlshortener.algorithm;

import jakarta.annotation.PostConstruct;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


public class TokenUrlShortener implements IUrlShortener {

    @Autowired
    @NotNull
    private ZooKeeper zooKeeper;

    @Value("${TokenUrlShortener.counterPath}")
    @NotNull
    private String counterPath;


    @Value("${TokenUrlShortener.counterRange}")
    private int counterRange;

    @NotNull
    private String clientPath;

    private int counterValue;

    private int counterStart;
    private int counterEnd;


    @PostConstruct
    public void init(){
        try {
            clientPath = zooKeeper.create(counterPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            List<String> children = zooKeeper.getChildren("/", false)
                    .stream()
                    .filter(child -> child.startsWith("counterRange"))
                    .sorted().toList();
            int index = children.indexOf(clientPath.substring(1));
            counterStart = 1 + (index * counterRange);
            counterEnd = (index +1) * counterRange;
            counterValue = counterStart;
            System.out.println("Counter range for this server is " + counterStart + " -> " + counterEnd);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public @NotNull String convert(@NotNull String longUrl) {

        String base62Val = convertCounterToBase62(counterValue);
        counterValue++;
        return base62Val;
    }

    @NotNull
    private String convertCounterToBase62(int counterValue) {
        StringBuilder base62Val = new StringBuilder();
        while (counterValue != 0){
            int val = counterValue % 62;
            counterValue = counterValue /62;
            base62Val.insert(0, convertValToBase62(val));
        }
        return base62Val.toString();
    }

    private String convertValToBase62(int val) {
        if (val >= 0 && val <= 9){
            return String.valueOf(val);
        }else if (val > 9 && val <= 35){
            char c = (char)('A' + (val - 10));
            return String.valueOf(c);
        }else{
            char c = (char)('a' + (val - 36));
            return String.valueOf(c);
        }
    }
}
