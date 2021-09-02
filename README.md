# Example microservice
<a href="https://twitter.com/andreshincapier"><img src="**_https://img.shields.io/twitter/follow/andreshincapier.svg_**?label=Follow" /></a>

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