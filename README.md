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
1. analyzeDate-> date of analysation
2. details
2.1. firstPost -> date of first post
2.2. lastPost -> date of last post
2.3. totalPosts -> number of posts
2.4. totalAcceptedPosts -> number of accepted posts
2.5. avgScore -> result of division totalPosts/score
