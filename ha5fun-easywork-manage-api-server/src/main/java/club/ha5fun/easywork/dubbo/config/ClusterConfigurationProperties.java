package club.ha5fun.easywork.dubbo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author chen
 * @Company ha5fun.club
 * 读取配置文件
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class ClusterConfigurationProperties {
    /**
     *     节点
     */
    private List<String> nodes;
    /**
     * 最大重定向次数
     */
    private Integer maxRedirects;
}
