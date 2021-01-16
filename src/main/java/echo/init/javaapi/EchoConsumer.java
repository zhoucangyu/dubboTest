package echo.init.javaapi;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import echo.api.EchoService;

public class EchoConsumer {

    public static void main(String[] args) {
        ReferenceConfig<EchoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("java-echo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface(EchoService.class);
        EchoService greetingService = reference.get();
        String message = greetingService.echo("Hello world!");
        System.out.println(message);
    }

}
