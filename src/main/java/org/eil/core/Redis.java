package org.eil.core;

import redis.clients.jedis.Jedis;

import java.util.Date;

public class Redis {

    private Jedis jedis;
    public Redis() {
         this.jedis = new Jedis("localhost",7000);
    }

    public long write(String value,int iteration){
        long start = new Date().getTime();
        for (int i = 0; i < iteration; i++) {
            jedis.set("key" + i, value + i);
        }
        return (new Date().getTime()) - start;
    }

    public long read(int iteration){
        long start = new Date().getTime();
        for (int i = 0; i < iteration; i++) {
            jedis.get("key" + i);
        }
        return (new Date().getTime()) - start;
    }
    public void delete(int iteration){
        for (int i = 0; i < iteration; i++) {
            jedis.del("key" + i);
        }
    }
}
