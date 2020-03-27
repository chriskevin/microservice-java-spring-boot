package se.chriskevin.microservice.springboot.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HazelcastConfig {

  @Bean
  public Config hazelCastConfig() {
    return new Config()
        .setInstanceName("hazelcast-instance")
        .addMapConfig(
            new MapConfig()
                .setName("users")
                .setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU))
                .setTimeToLiveSeconds(20));
  }
}
