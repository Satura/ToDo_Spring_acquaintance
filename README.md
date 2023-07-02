## Проект ToDo из курса по знакомству с Spring Framework на Stepik

---
#### Проект знакомит с :
* использованием Docker, PostgreSQL, DBeaver; 
* использованием Spring Data JPA;
* реализацией REST для управления базой задач HTTP запросами
  * внесение новой задачи (POST) 
  ```
  {"date": "2025-08-06",
  "description": "test_task"}
  ```
  
  * вывод полного перечня задач (GET) /tasks
  * вывод задачи по id (GET) /tasks/{id}
  * обновление задачи по id (PUT) /tasks/{id}
  * удаление задачи по id (DELETE) /tasks/{id}
    * внесение отметки о выполнении (2 способа)
      * (PATCH) /tasks/{id}:mark-as-done
      * (PATCH) /tasks/{id} 
          ```
          {"done": true}
          ```

