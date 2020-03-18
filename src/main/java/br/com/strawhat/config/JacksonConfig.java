package br.com.strawhat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.strawhat.model.Batismo;
import br.com.strawhat.model.PadrinhosEvento;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PadrinhosEvento.class);
				objectMapper.registerSubtypes(Batismo.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
