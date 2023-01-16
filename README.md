# Getting started with Spring Java and ElasticSearch

Ref: 
- https://www.baeldung.com/spring-data-elasticsearch-tutorial


## Running 
- Init locally a docker image of elasticsearch:
```
docker run -d --name elasticsearch -p 9200:9200 -e ES_JAVA_OPTS="-Xms1g -Xmx1g" -e xpack.security.enabled=false  -e "discovery.type=single-node" elasticsearch:8.6.0
```
- Build and test

```
mvn clean install
```

- Run

```
mvn spring-boot:run
```

- Create article
```
curl --location --request POST 'http://localhost:8080/api/article'
```

- Get articles by author
```
curl --location --request GET 'http://localhost:8080/api/article/author/John Smith'
```

