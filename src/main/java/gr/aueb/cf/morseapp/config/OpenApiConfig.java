package gr.aueb.cf.morseapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "MorseApp API",
                version = "1.0.0",
                description = "API τεκμηρίωση για μετατροπή κειμένου - κώδικα Morse",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "MorseApp Dev Team",
                        email = "developer@morseapp.gr",
                        url = "https://cf.gr"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MorseApp API")
                        .version("1.0.0")
                        .description("REST API για μετατροπή κώδικα Morse - Κείμενο με Authentication")
                        .contact(new Contact()
                                .name("Coding Factory")
                                .email("support@cf.gr")
                                .url("https://cf.gr"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
