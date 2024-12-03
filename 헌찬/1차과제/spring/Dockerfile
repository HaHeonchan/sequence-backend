# 1. 베이스 이미지 선택 (OpenJDK 17 사용)
FROM openjdk:17-jdk-slim

# 2. JAR 파일을 컨테이너로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3. 포트 노출 (Spring Boot 기본 포트는 8080)
EXPOSE 8080

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]