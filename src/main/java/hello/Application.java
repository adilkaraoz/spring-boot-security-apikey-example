package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adilkaraoz.spring.boot.apikey.ApiKeyValidatorService;
import com.adilkaraoz.spring.boot.apikey.DefaultApiKeyValidator;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "hello" })
public class Application implements CommandLineRunner {

	@Autowired
	private ApiKeyValidatorService validatorService;

	/*
	 * Also you can implement own ApiKeyValidator implements from
	 * ApiKeyValidatorBase
	 */
	@Autowired
	private DefaultApiKeyValidator apiKeyValidator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		apiKeyValidator.addApiKey("your api key here");
		validatorService.setApiKeyValidator(apiKeyValidator);
	}
}
