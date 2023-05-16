package org.eil;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.collection.ISet;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.eil.constants.Constant;
import org.eil.core.Redis;
import redis.clients.jedis.*;

import java.util.*;

public class RedisTest {
    public static void main(String[] args) {

        Redis redis = new Redis();
        System.out.println(redis.write(Constant.TEXT,300000));

        System.out.println(redis.read(300000));

    }
}
