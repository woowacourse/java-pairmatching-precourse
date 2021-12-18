## 기능 구현

- 입력 기능
  - 4가지 기능 중 하나를 입력 받아 실행
  - 과정, 레벨, 미션을 입력받음
    - 존재하는 정보인지 확인, 예외처리
    - form이 맞는 지 확인, 예외처리

- 과정, 레벨, 미션 정보 실행 전 초기화
  - 변경 불가

- 레벨 구현
  - 레벨마다 미션 존재
    - 레벨에 존재하는 미션을 모두 출력하는 기능
  - 미션마다 페어를 만듬
  - 미션에 적용된 페어를 레벨이 저장해 이미 페어된지 여부를 판단

- 미션 구현
  - 페어 매칭을 진행, 검증하는 기능
  - 미션은 페어 매칭이 되었다면 이를 저장
  - 매칭 결과를 출력 하는 기능
  - 저장 여부를 판단해 매칭을 다시 실행할 수 있음
  
- 페어 매칭
  - 크루의 목록에서 shuffle 함수로 매칭
  - 백앤드와 프론트 엔드 구분 없이 매칭
  - 정원이 홀수라면 마지막 3명 끼리 매칭
  - 해당 레벨에서 페어가 됬으면 같은 레벨의 미션에서는 더이상 페어 불가

- 크루 구현
  - 자신의 소속과 이름 저장
  - .md 파일에서 읽어와서 생성

- 모든 페어 초기화 기능

## 기능별 클래스 할당

- Crew Class
  - 자신의 코스, 이름 저장

- CrewDataBase class
  - 레벨 별로 크루들의 객체를 HashMap으로 저장하는 클래스

- Pair class 
  - 매칭이된 크루원을 리스트로 저장
  - 리스트 출력 기능

- Course class
  - 백앤드와 프런트 앤드 코스 존재

- Mission class 
  - 미션마다 매칭된 Pair를 리스트로 저장
    - Pair리스트 출력 기능
  - 크루원의 이름으로 매칭 기능
    - 홀, 짝에 따라 매칭 분리
  - 매칭된 여부를 저장
  