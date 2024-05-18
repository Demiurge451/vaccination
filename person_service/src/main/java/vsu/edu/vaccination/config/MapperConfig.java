package vsu.edu.vaccination.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vsu.edu.vaccination.mapper.IdMapper;
import vsu.edu.vaccination.model.id_container.IdContainer;

@Configuration
public class MapperConfig {
    @Bean
    public <T extends IdContainer<ID>, ID> IdMapper<T, ID> idMapper() {
        return new IdMapper<>();
    }
}
