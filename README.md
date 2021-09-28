# Example microservice
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=andreshincapier_ms-survey-demo&metric=alert_status)](https://sonarcloud.io/dashboard?id=andreshincapier_ms-survey-demo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=andreshincapier_ms-survey-demo&metric=coverage)](https://sonarcloud.io/dashboard?id=andreshincapier_ms-survey-demo)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=andreshincapier_ms-survey-demo&metric=bugs)](https://sonarcloud.io/dashboard?id=andreshincapier_ms-survey-demo)

Microservice with clean architecture

## Installation

Use  gradle to management [gradle](https://docs.gradle.org/current/userguide/userguide.html) to run project.

```bash
sh ./gradlew build
```

## Usage

#### Start project

```bash
sh ./gradlew bootrun  
```

#### Test end-point

```bash
curl -i http://localhost:8080/api/robin-food/survey/list-all-active 
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
