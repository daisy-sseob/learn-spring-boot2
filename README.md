# ✨ Spring boot의 기본적인 기능을 탐구하는 프로젝트 입니다.

> spring framework보다 간소화된 web custom, spring이 제공하는 여러 기능들이 자동 설정으로 인해 간단하게 사용가능한 기능들을 실제로 사용해보는 프로젝트

- Spring boot에서 제공하는 WebMvc 자동설정에 대해 알아봄.
- Spring boot의 자동설정을 해치치 않으면서 해당 설정 custom하기.
- 자동설정을 통해 사용하기 편리해진 기능들에 대해서 알아봄.
  - cors, jpa auto configuration, database설정, hateoas 등등 

> DB는 postgres를 사용. docker를 이용해 postgres를 설치한다.
```xml
$ docker run -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_USER=sseob -e POSTGRES_DB=springboot --name postgres_boot -d postgres
- bash로 접속: docker exec -i -t postgres_boot
```
