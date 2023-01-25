### Метеорологическая компания собирает данные о погоде в некоторых городах с помощью сенсеров. Данные с помощью REST пересылаются в формате JSON.
### Замер давление происходит в определенном районе и занимает 1 час, если в течение этого времени погода не испортилась, то значение становится false.
### Данную статистику необходимо собрать, какая в каждом районе была погода и вернуть количество.
### Данные о районах проведения замера указаны как уникальное значение.

## Стек технологий:

![java](https://img.shields.io/badge/Java--17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Rest](https://img.shields.io/badge/Spring_Boot--2.7.0-F2F4F9?style=for-the-badge&logo=spring-boot)
![PostgresSQL](https://img.shields.io/badge/PostgreSQL--42.3.6-316192?style=for-the-badge&logo=postgresql&logoColor=white)

![Liquibase](https://img.shields.io/badge/Liquibase-4.17.2-red)
![Junit](https://img.shields.io/badge/JUNIT-4.13.1-orange)
![Mockito](https://img.shields.io/badge/MOCKITO-3.5.13-red)
![Log4j2](https://img.shields.io/badge/Log4j-2.18.0-green)
![Lombok](https://img.shields.io/badge/Lombok-1.18.24-white)

## Контакты
[![Telegram](https://img.shields.io/badge/TELEGRAM-26A5E4?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/romanka3)

### chansforman@gmail.com

## Перед запуском установите:

- Java 17
- Apache Maven 3.x
- Postgres 14
- Postman

## Запуск приложения

1. Создать бд:
```sql
create database weather_changer_v;
```

2. Запуск приложения с maven. Перейдите в корень проекта через командную строку и выполните команды:
```
    mvn clean install
    mvn spring-boot:run
```
 

3. Введите команду http://localhost:8080/cities/addCity POST

 ![](src/main/resources/image/Screenshot_14.png)

Будет возвращено:

![](src/main/resources/image/Screenshot_16.png)

При повторной попытке зарегистрировать одинаков значение будет выведено исключение

![](src/main/resources/image/Screenshot_18.png)

Введите команду http://localhost:8080/country/addCountry POST

![](src/main/resources/image/Screenshot_19.png)

Будет возвращено:

![](src/main/resources/image/Screenshot_20.png)

Введите команду http://localhost:8080/streets/addStreet POST

![](src/main/resources/image/Screenshot_21.png)

Будет возвращено:

![](src/main/resources/image/Screenshot_22.png)

 Введите команду http://localhost:8080/sensors/registration POST

![](src/main/resources/image/Screenshot_2.png)

В ответ на запрос будет получен ответ

![](src/main/resources/image/Screenshot_11.png)

 Введите команду http://localhost:8080/measurements/add POST

![](src/main/resources/image/Screenshot_23.png)

 В ответ на запрос придет 

![](src/main/resources/image/Screenshot_24.png)

 Введите команду http://localhost:8080/measurements/rainyDaysCount GET

![](src/main/resources/image/Screenshot_4.png)

 В ответ на запрос придет

![](src/main/resources/image/Screenshot_8.png) 

 Значение будет 0 т.к данные дни отсутствуют

 Введите команду http://localhost:8080/measurements/allMeasurement

![](src/main/resources/image/Screenshot_3.png)

 В ответ на запрос придет список всех элементов 

 Введите команду http://localhost:8080/users/registration POST

![](src/main/resources/image/Screenshot_15.png)

В ответ придет сообщение

 ![](src/main/resources/image/Screenshot_12.png)