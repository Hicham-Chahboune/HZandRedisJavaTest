package org.eil;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.eil.constants.Constant;
import org.eil.core.Hazelcast;

public class HazelcastTest {

    public static void main(String[] args) {

        org.eil.core.Hazelcast hazelcast =new Hazelcast();

        System.out.println(hazelcast.write(Constant.TEXT,300000));
        System.out.println(hazelcast.read(300000));

    }
}