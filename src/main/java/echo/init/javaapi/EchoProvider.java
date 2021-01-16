package echo.init.javaapi;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import echo.api.EchoService;
import echo.impl.EchoServiceImpl;

public class EchoProvider {

    public static void main(String[] args) throws Exception {
        ServiceConfig<EchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("java-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.setInterface(EchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();
        System.out.println("java-echo-provider is running.");
        System.in.read();
    }

}
