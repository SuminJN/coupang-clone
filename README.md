# 쿠팡 클론 코딩 프로젝트

## 1. 주요 기능

1.1 상품 추가

- 새로운 상품을 추가할 수 있다.
- 상품 정보: 상품명, 가격, 상품 수량

1.2 상품 조회

- 상품 목록을 조회할 수 있다.

1.3 상품 수정

- 상품 정보를 수정할 수 있다.
- 수정 가능 정보: 상품명, 가격, 상품 수량

1.4 상품 삭제

- 저장된 상품을 삭제할 수 있다.


## 2. 개발 도구 및 환경

- IDE: IntelliJ IDEA
- 빌드 도구: Gradle
- Java 버전: Java 17
- 프레임워크: Spring Boot
- 데이터베이스: MariaDB
- 템플릿 엔진: Thymeleaf


## 3. 데이터 모델

- Item: 상품 정보를 저장하는 테이블
  - id: 상품 ID
  - name: 상품명
  - price: 가격
  - stock: 상품 수량
  - createdAt: 상품 생성일
  - updatedAt: 상품 수정일