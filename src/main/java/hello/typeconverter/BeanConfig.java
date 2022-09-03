package hello.typeconverter;

import hello.typeconverter.controller.MallInfoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MallInfoDTO getMallInfoDTO() {
        MallInfoDTO dto = new MallInfoDTO();
        return dto;
    }
}
