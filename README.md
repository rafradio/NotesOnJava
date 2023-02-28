# Домашняя работа за 22.02.23.
#### Студент GeekBrains: Абдюшев Р.Н.
#### GU | Разработчик | 2042
<br>

## Помежуточная аттестация

#### Конструкция приложения
Сделано full-stack веб-приложение с использованием Java Spring.
Данные сохраняются в MySQL.
Веб-страницы - HTML, Css, JavaScript.
Домашняя работа находится в папке "/notesSpringNew".
Папка "data_json" -для json файлов с данными заметки.
* NotesSpringNewApplication.java - main файл для запуска приложения;
* /src/main/java/com/java/notesSpringNew/notesSpringNew - путь к данному файлу;
* /controllers - паккидж с контроллерами в которых прописан маппинг;    
* /models - модель "заметка";
* /dao - обращение к БД MySQL, запись и чтение;
<br>
#### Конструкция веб-страниц
* http://localhost:8080/main - Интерфейс главной веб страницы;
    > выводятся все заметки из БД в порядке редактирования<br>
    > при нажатии на заметку попадаешь на страницу данной заметки<br>
    > размещена кнопка "новая заметка"<br>
* http://localhost:8080/edit - Интерфейс веб страницы заметки;
    > открыты только поля названия и тела заметки<br>
    > размещены кнопки записи редактирования, удаления заметки<br>
    > размещены кнопки записи в json file, возврата в main<br>
    > в качестве эскперимента в бэкенд отправил url с параметрами<br>
    > бэк читает параметры и записывает файл, по возвращению во фронт<br>
    > проигрывается анимация о произошедшей записи<br>
* http://localhost:8080/new - Интерфейс веб страницы новой заметки;
    > id и время присваиваются автоматически<br>



