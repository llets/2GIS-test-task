# Тестовое задание для QA-инженеров

## Описание проекта

Тестируемый сервис - сервис для хранения избранных мест пользователей, доступный по адресу https://regions-test.2gis.com/

Данный проект содержит авто-тесты для проверки корректности работы API метода создания избранного места.

## Краткое описание файлов, содержащихся в проекте:

main/java - универсальные классы, которые можно использовать в других проектах
* main/java/constants/PatternConstants.java - класс, содержащий форматы дат
* main/java/constants/ResponsePathConstants.java - класс, содержащий пути для парсинга JSON-ответов
* src/main/java/models/Config.java - класс для хранения конфигурационных данных
* src/main/java/utils/AssertUtils.java - утилитарный класс для проверок
* src/main/java/utils/ConfigAndDataUtils.java - утилитарный класс для загрузки конфигурационных и тестовых данных из файлов
* src/main/java/utils/ResponseUtils.java - утилитарный класс для работы с ответами (создание объектов на основе тела ответа и получение статус-кода)

test/java - классы, необходимые для тестирования API создания избранных мест пользователей
* src/test/java/models/CreateFavPlaceResponse.java - модель хранения данных из ответа
* src/test/java/models/Place.java - модель для хранения данных о месте
* src/test/java/requests/v1/auth/tokens/TokenRequest.java - класс для работы с endpoints токенов
* src/test/java/requests/v1/favourites/FavRequest.java - класс для работы с endpoints избранного
* src/test/java/utils/ApiUtils.java - утилитарный класс для отправки запросов
* src/test/java/utils/SpecificationUtils.java - утилитарный класс для работы со спецификациями
* src/test/java/tests - директория с тестами:
  * BaseTest.json - класс базового теста с методом для получения токена и методом для получения списка тестовых данных
  * createFavourite/CreateFavouriteBaseTest.java - класс-потомок BaseTest, содержит метод для проверки ответа сервиса и выполнения запроса
  * остальные классы связаны с проверкой требований к полям запроса