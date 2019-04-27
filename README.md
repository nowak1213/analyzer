# analyzer
The project aims to process basic analysis of xml file

Steps to run
1. Clone repository
2. Use cmd and go to /analyzer folder
3. mvn clean install
4. mvn spring-boot:run
5. Use web browser or curl to run your request

You can also use docker to run application:
1. docker pull nowak2809/analyzer-docker
2. docker run -p 8080:8080 nowak2809/analyzer-docker

Request parameters:
1. url -> url to xml file ex: https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml

Response json:
{
    "analyzeDate": "2019-04-27T14:43:21.877", -> date of analysation
    "details": {
        "firstPost": "2015-07-14T18:39:27.757", -> date of first post
        "lastPost": "2015-09-14T12:46:52.053", -> date of last post
        "totalPosts": 80, -> number of posts
        "totalAcceptedPosts": 7, -> number of accepted posts
        "avgScore": 2 -> result of division totalPosts/score
    }
}
