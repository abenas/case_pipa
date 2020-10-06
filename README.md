# Case PIPA Studios

### Descrição


Este é um pequeno projeto que implementa o case técnico sugerido.

Foi criado em **Java 8** , **SpringBoot** e **Gradle**.
    
### Execução

Para execução, deve-se utilizar o comando abaixo:
        
        ./gradlew clean build run
        
As requisições devem ser direcionadas ao endpoint **http://localhost:8080**

        GET /highscorelist
        GET /{id}/position
        POST /score
        