# md_homework


구현스택
>spring-boot 2.1.4, spring-data-jpa

DB 스키마
------------
https://www.erdcloud.com/d/euuN27ZPStxKJYo3m


테스트 방법
-------------
1. 프로젝트 내의 도커 설정 디렉토리(docker-file)로 이동함
> cd docker-file

2. 작성된 docker-compose.yml에 따라 mysql DB와 spring서버 컨테이너를 각각 생성함
> docker-compose up

3. url 테스트 
```
 1) 신청서 리스트: localhost:8080/api/house-apply/list
 2) 고객 리스트: localhost:8080/api/customer/list
 3) 이사업체 리스트: localhost:8080/api/move-company/list
 ```
