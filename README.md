# spring-boot-security-apikey-example
This project demonstrates the using of [spring-boot-security-apikey](https://github.com/adilkaraoz/spring-boot-security-apikey) project

#### You can use default api key validator
```java

	defaultApiKeyValidator.addApiKey("your api key here")
	validatorService.setApiKeyValidator(defaultApiKeyValidator);
```

#### Also you can define custom api key validator implements from ApiKeyValidatorBase
```java

	class CustomApiKeyValidator implements ApiKeyValidatorBase {

		boolean validate(String apiKey, String requestURI, String referrer) {
			// control apiKey for requestURI and referrer then return true or false here
		}
	
		boolean isEnabled() {
			return true; // If false, validator don't control api key
		}
	}
	
	validatorService.setApiKeyValidator(customApiKeyValidator);
```