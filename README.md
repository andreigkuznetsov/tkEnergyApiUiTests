# Автотесты для API-сервиса и UI веб-сайта<br>ТК "Энергия" (https://nrg-tk.ru/)

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
- [x] Создание, изменение и удаление контрагента в личном кабинете<b>*</b>

### API тесты:

- [x] Успешный LogIn и LogOut (личный кабинет пользователя)
- [x] Создание и удаление адресата
- [x] Создание и удаление накладной на перевозку
- [x] Получение данных о пользователе аккаунта
- [x] Получение списка городов обслуживания
- [x] Поиск города обслуживания по почтовому индексу

##### * - автотесты построены таким образом, что все создаваемые сущности, удаляются в ходе выполнения тест-кейсов.  

## Стек технологий:

![Intelij_IDEA](/img/logo/Intelij_IDEA.png)![Java](/img/logo/Java.png)![Selenide](/img/logo/Selenide.png)![Selenoid](/img/logo/Selenoid.png)![Gradle](/img/logo/Gradle.png)![JUnit5](/img/logo/JUnit5.png)![Allure Report](/img/logo/Allure_Report.png)![AllureTestOps](/img/logo/AllureTestOps.png)![Github](/img/logo/Github.png)![Jenkins](/img/logo/Jenkins.png)![RestAssured](/img/logo/Rest-Assured.png)![Telegram](/img/logo/Telegram.png)![Jira](/img/logo/Jira.png)

<b>Java, Selenide, Selenoid, Gradle, JUnit5, Allure Reports, TestOps, GitHub, Jenkins, RestAssured, Telegram (уведомления), Jira</b>
#
- В данном проекте автотесты написаны на <b>Java</b> с использованием фреймворка <b>Selenide</b> для UI-тестов и библиотеки <b>REST-Assured</b> для API-тестов.

- Для сборки проекта используется <b>Gradle</b>.

- <b>JUnit 5</b> используется как фреймворк для модульного тестирования.

- Запуск тестов выполняется из системы <b>Jenkins</b>.

- <b>Selenoid</b> используется для запуска браузеров в контейнерах <b>Docker</b>.

- <b>Allure Report</b>, <b>Allure TestOps</b>, <b>Jira</b>, <b>Telegram Bot</b> используются для визуализации результатов тестирования.

- В качестве хостинга для данного проекта используется <b>GitHub</b>.

## Локальный запуск тестов:

### Запуск тестов из терминала с заполненным файлом remote.properties:

```bash
gradle clean test
```

### Запуск тестов с не заполненным файлом remote.properties:

```bash
gradle clean test 
  -DremoteBrowserUrl=https://${LOGIN}:${PASSWORD}@selenoid.autotests.cloud/wd/hub/
  -Dbrowser=${BROWSER}
  -DbrowserVersion=${BROWSER_VERSION}
  -DbrowserSize=${BROWSER_SIZE}
  -Dthreads=${THREADS}
```

#### где:

- <b>-DremoteBrowserUrl</b> - логин, пароль и адрес удаленного сервера, где будут выполняться тесты 
- <b>-Dbrowser</b> - браузер, в котором будут выполняться тесты (по умолчанию chrome)
- <b>-DbrowserVersion</b> - версия браузера (по умолчанию 91.0)
- <b>-DbrowserSize</b> - размер окна браузера (по умолчанию 1920x1080)
- <b>-Dthreads</b> - количество потоков выполняющихся тестов (по умолчанию 4)

### Сформировать allure отчет:

```bash
allure serve build/allure-results
```

## Удаленный запуск тестов:

### Для запусков автотестов используется [Jenkins](https://jenkins.autotests.cloud/job/09-andreikuzn-tk-energy-api-ui-tests/).

### Параметры сборки:

```bash
BROWSER - браузер, в котором будут выполняться тесты (по умолчанию chrome)
BROWSER_VERSION -  версия браузера (по умолчанию 91.0)
BROWSER_SIZE - азмер окна браузера (по умолчанию 1920x1080)
THREADS - количество потоков выполняющихся тестов (по умолчанию 4)
ENVIRONMENT - тестовый стенд, на котором будут запущены тесты (по умолчанию DEMO)
COMMENT - комментарий, который отображается в сообщении Телеграмм-бота (по умолчанию "TK Energy API and UI autotests")
```
#### Для запуска сборки необходимо нажать на кнопку "Собрать с параметрами", затем, выбрать (или оставить по умолчанию) значения параметров и нажать кнопку "Собрать".
#
![jenkins_start_window](/img/pics/jenkins_start_window.png)
#
#### Для анализа результатов запусков в Jenkins используется Allure Reports

## Описание Allure Reports:

#### После выполнения сборки, в разделе "История сборок" в строке с номером сборки появится значок Allure Report, кликнув по которому, откроется страница с сформированным отчетом по данной сборке. 
#
![allure_start_window](/img/pics/allure_start_window.png)
#
### Пример отчета о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/09-andreikuzn-tk-energy-api-ui-tests/8/allure/)

#### Overview страница Allure-отчета содержит следующие разделы:

- <b>ALLURE REPORT</b> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
- <b>TREND</b> - отображает тренд прохождения тестов от сборки к сборке
- <b>SUITES</b> - отображает распределение результатов тестов по тестовым наборам
- <b>ENVIRONMENT</b> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
- <b>CATEGORIES</b> - отображает распределение неуспешно прошедших тестов по видам дефектов
- <b>FEATURES BY STORIES</b> - отображает распределение тестов по функционалу, который они проверяют
- <b>EXECUTORS</b> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)
#
![allure_main_window](/img/pics/allure_main_window.png)
#
#### На странице Suites представляется стандартное распределение выполнявшихся тестов по классам (тестовым наборам), в которых находятся тестовые методы (шаги).

#### Каждый UI тестовый набор содержит скриншот, сделанный после последнего шага, видео прохождения и консольные логи браузера.
#
![allure_overview_ui_window](/img/pics/allure_overview_ui_window.png)
#
#### Каждый API тестовый набор содержит детальные данные по каждому выполненному запросу и ответу сервера.
#
![allure_overview_api_window](/img/pics/allure_overview_api_window.png)
#
## Интеграция с AllureTestOps:
### Для запуска автотестов, отображения и анализа результатов сборок также используется [Allure TestOps](https://allure.autotests.cloud/project/1027/dashboards)

#### Overview дашборд

![testops_overview_dashboard](...)

#### Дашборд по типам тестов

![testops_automation_dashboard](...)

#### Дашборд по тестовым стендам

![testops_stages_dashboard](...)

#### Дашборд с аналитикой по команде

![testops_team_dashboard](...)

#### Результаты запусков тестовых прогонов

![testops_launches_dashboard](...)

#### Страница с test-планами

![testops_launches_dashboard](...)

#### Пример списка тестов и их прохождения
#
![testops_cases_dashboard](/img/pics/testops_cases_dashboard.png)
#
## Интеграция с Jira:
### Запускаемые кейсы и их результаты можно добавить в [Jira](https://jira.autotests.cloud/browse/HOMEWORK-334)

![jira_issue_334](/img/pics/jira_issue_334.png)

## Интеграция с Telegram:
### После прохождения тестов, в telegram канал приходит оповещение с результами

<p align="left">
  <img src="/img/pics/telegram_results_1.jpg" alt="Telegram" width="440">
  <img src="/img/pics/telegram_results_2.jpg" alt="Telegram" width="381">
</p>

## Пример запуска и прохождения UI теста на видео: 

![selenoid_video](/img/pics/selenoid_video.gif)
