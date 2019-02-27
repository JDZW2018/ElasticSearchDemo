package cn.com.yusys.search.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author 94946
 * @date 2019/2/13
 * @DESC
 */
@Configuration
public class ESconfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ESconfig.class);

    /**
     * elk集群地址
     */
    @Value("${spring.data.elasticsearch.hostName}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${spring.data.elasticsearch.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${spring.data.elasticsearch.pool}")
    private String poolSize;

    @Bean
    public TransportClient client() {
        LOGGER.info("初始化开始。。。。。");
        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
                    .put("cluster.name",clusterName)
                    .build();
            //配置信息Settings自定义,下面设置为EMPTY
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
            transportClient.addTransportAddresses(transportAddress);


        } catch (Exception e) {
            LOGGER.error("elasticsearch TransportClient create error!!!", e);
        }

        return transportClient;
    }
}
