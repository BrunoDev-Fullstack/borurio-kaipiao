package vboot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import vboot.core.common.utils.ruoyi.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableCaching
@SpringBootApplication
@Slf4j
@EnableAsync
@MapperScan("vboot.app.mapper")
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Application.class, args);
        Environment env = app.getEnvironment();
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(path)) {
            path = "";
        }

        log.info("\n----------------------------------------------------------\n\t" +
                // Local接口访问地址
                // Endereço local para acessar a interface da aplicação
                "Application  is running! \n\t" +
                "Local接口访问地址: \t\thttp://localhost:" + port + path + "/doc.html" + "\n\t" +
                // External访问网址
                // Endereço externo para acesso remoto à aplicação
                "External访问网址: \thttp://" + ip + ":" + port + path + "/doc.html" + "\n\t");
    }

}
