# Case HIGH SCORES
<br/>

#### **Description**

This is a small application that implements the suggested technical case.

<br/>

#### **Requirements**

- Java 8
- SpringBoot 2.3.4
- Gradle 6.3
- Linux, Bash and Httpie is recommended.

<br/>

#### **Building**

To build and run this application, run the commands below:
> ./gradlew clean build run

After it starts, the application will log to the output the folling line:
> 2023-05-06 00:27:34.995  INFO 28729 --- [           main] com.abenas.score.ScoreApplication        : Started ScoreApplication in 1.439 seconds (JVM running for 1.747)

<br/>

#### **Interaction**

You can interact with the aplication by making http requests to the local endpoint exposed:
> http://localhost:8080


<br/>

#### **Operations**

The following operations are available:

| action                | description                                       |
|-----------------------|---------------------------------------------------|
|GET /highscorelist     | returns the current highscore list                |
|GET /**{id}**/position | returns the userId position                       |
|POST /score            | inputs an userId score and register its position  |

<br/>

#### **Use case**

Getting current score list:

    $ http localhost:8080/highscorelist

Register score for player one: 

    $ http POST localhost:8080/score userId=1 points=5000

Get the updated score list:

    $ http localhost:8080/highscorelist
 
Response:

```json
{
    "highscores": [
        {
            "points": 5000,
            "position": 1,
            "userId": 1
        }
    ]
}
```

Register a score for player two with higher points: it will assume first position

    $ http POST localhost:8080/score userId=2 points=10000

Getting the updated score list

    $ http localhost:8080/highscorelist

Response:

```json
{
    "highscores": [
        {
            "points": 10000,
            "position": 1,
            "userId": 2
        },
        {
            "points": 5000,
            "position": 2,
            "userId": 1
        }
    ]
}
```