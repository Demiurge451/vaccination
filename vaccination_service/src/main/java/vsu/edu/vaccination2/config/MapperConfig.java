package vsu.edu.vaccination2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vsu.edu.vaccination2.mapper.IdMapper;
import vsu.edu.vaccination2.model.id_container.IdContainer;

@Configuration
public class MapperConfig {
    @Bean
    public <T extends IdContainer<ID>, ID> IdMapper<T, ID> idMapper() {
        return new IdMapper<>();
    }
}
