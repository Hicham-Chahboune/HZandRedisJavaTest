package org.eil.core;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Date;

public class Hazelcast {
    IMap<String,String> set;
    public Hazelcast() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("hello-world");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

        this.set = client.getMap("my-test-map");
    }

    public long write(String value,int iteration){
        long start = new Date().getTime();
        for (int i = 0; i < iteration; i++) {
            set.put("key" + i, value + i);
        }
        return (new Date().getTime()) - start;
    }

    public long read(int iteration){
        long start = new Date().getTime();
        for (int i = 0; i < iteration; i++) {
            set.get("key" + i);
        }
        return (new Date().getTime()) - start;
    }
    public void delete(int iteration){
        for (int i = 0; i < iteration; i++) {
            set.delete("key" + i);
        }
    }

}
