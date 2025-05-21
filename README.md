# FetchDataApplication

Aplikacja Spring Boot, która pobiera dane typu `Post` z zewnętrznego API (`https://jsonplaceholder.typicode.com/posts`) 
i zapisuje każdy post jako osobny plik JSON w katalogu `./saved-posts/`.

```bash 

mvn clean install
mvn spring-boot:run