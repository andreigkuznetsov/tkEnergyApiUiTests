# Проект с автотестами для API-сервиса и UI-части веб-сайта ТК "Энергия" (https://nrg-tk.ru/)

![TK_Energy](/img/logo/energy_logo.png)

## Cписок автоматизированных тест-кейсов в данном проекте:

### UI тесты:

- [x] Проверка отображения главной страницы сайта  
- [x] Проверка поиска по сайту и отображения результатов
- [x] Проверка отображения элементов левого бокового меню
- [x] Проверка работы виджета он-лайн калькулятора на главной странице 
- [x] Проверка работы виджета он-лайн отслеживания на главной странице
- [x] Проверка переходов в разделы основного меню сайта
- [x] Проверка переходов и наличия контента страниц раздела "О компании"
- [x] Авторизация в личный кабинет клиента с валидными данными
- [x] Авторизация в личный кабинет клиента с невалидными данными
- [x] Проверка, что страницы разделов в личном кабинете открываются
- [x] Создание, изменение и удаление контрагента в личном кабинете*

### API тесты:

- [x] Успешный LogIn и LogOut (личный кабинет пользователя)
- [x] Создание и удаление адресата
- [x] Создание и удаление накладной на перевозку
- [x] Получение данных о пользователе аккаунта
- [x] Получение списка городов обслуживания
- [x] Поиск города обслуживания по почтовому индексу

* - автотесты построены таким образом, что все сущности, создаются и удаляются в ходе выполнения тест-кейсов.  

## Стек технологий:

![Intelij_IDEA](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Intelij_IDEA.png)![Java](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Java.png)![Selenide](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Selenide.png)![Selenoid](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Selenoid.png)![Gradle](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Gradle.png)![JUnit5](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/JUnit5.png)![Allure Report](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Allure_Report.png)![AllureTestOps](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/AllureTestOps.png)![Github](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Github.png)![Jenkins](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Jenkins.png)![RestAssured](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Rest-Assured.png)![Telegram](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Telegram.png)![Jira](https://github.com/andreigkuznetsov/smallUIproject/blob/master/img/icons/Jira.png)

Java, Selenide, Selenoid, Gradle, JUnit5, Allure Reports, TestOps, Jenkins, RestAssured, Telegram (уведомления), Jira

## Запуск тестов с заполненными конфигурационными файлами *.properties:

### Для запуска тестов в BrowserStack:

```bash
gradle clean test -DdeviceHost=browserstack
```
### Для запуска тестов в Selenoid:

```bash
gradle clean test -DdeviceHost=selenoid
```
### Для запуска тестов в эмуляторе + Appium:

```bash
gradle clean test -DdeviceHost=emulation
``` 
### Для запуска тестов на реальном устройстве + Appium:

```bash
gradle clean test -DdeviceHost=real
``` 

### Для запусков автотестов используется Jenkins.

##### Примеры готовых сборок можно посмотреть [по ссылке](https://jenkins.autotests.cloud/job/09-andreikuzn-mobile-tests/)

### Анализ результатов запусков в Jenkins через Allure Reports

![Jenkins_Allure_Reports](img/allure_dashbord_mt.png)

![Jenkins_Allure_Reports1](img/allure_detailes_mt.png)

![Jenkins_Allure_Reports2](img/allure_detailes1_mt.png)

### Для отображения результатов сборок также используется Allure TestOps.

##### Примеры запусков и их результаты можно посмотреть [по ссылке](https://allure.autotests.cloud/project/920/dashboards)

### Пример списка тестов и их прохождения в Allure TestOps

![Allure TestOps](img/testops_detailes1_mt.png)

### Результаты запусков Launches в Allure TestOps

![Allure_Launches](img/testops_detailes_mt.png)

### Основной Dashboards

![Allure Dashboards](img/testops_dashbord_mt.png)

### Добавлена интеграция с Jira, где можно посмотреть запускаемые кейсы и их результаты.

##### Перейти в Jira можно [по ссылке](https://jira.autotests.cloud/browse/HOMEWORK-312)

![Jira](img/Jira_mt.png)

### После прохождения тестов в telegram канал приходит оповещение с результами.

![Telegram](img/Telegram_mt.jpg)

### Пример прохождения тестов можно посмотреть на видео

![video](img/video_mt.gif)
