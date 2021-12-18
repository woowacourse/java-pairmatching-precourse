## 기능목록

0. 프로그램 시작 기능
1. 파일 입출력으로 크루 목록 생성 기능
2. 페어 매칭 기능
    1. 크루 목록 셔플 기능
    2. 페어 히스토리 검색 기능
    3. 같은 레벨에서 만났는 지 유효성 검사
    4. 홀수라면 마지막 팀은 3명
    5. 3회 매칭이 실패하거나, 매칭이 불가능하면 에러 발생 (코스, 레벨, 미션 재선택)
3. 만들어진 페어 히스토리 추가 기능
4. 이미 매칭 정보가 있을 때, 재매칭 기능
    1. 예 -> 재매칭
    2. 아니오 -> 코스, 레벨, 미션 재선택
5. 페어 조회 기능
    1. 존재하지 않다면 매칭 이력이 없다고 안내
6. 프로그램 기능 선택 기능
    1. 매칭
    2. 조회
    3. 초기화
    4. 종료
7. 프로그램 초기화 기능
8. 프로그램 종료
9. 과정과 미션 출력 기능
10. 매칭 후, 결과 안내 기능
11. 잘못된 입력에 대한 유효성 검사 기능

## 클래스

### model
   1. Course
   2. Level
   3. Crew
   4. MatchingHistory
      1. Level
      2. List<Pair>
   5. MatchingInfo
      1. Map<String, List<Pair>
         1. String : ex)백엔드,레벨1,자동차경주
   6. Pair
      1. List<String>
   7. Mission
      1. Level

### view
   1. InputView
   2. OutputView
   3. ErrorView

### controller
   1. PairMatchingController
      1. MatchingHistory
      2. MatchingInfo

### validation
   1. UtilValidation
      1. 코스, 레벨, 미션 입력 유효성 검사

### constants
   1. Constants
   2. ErrorMsg
   3. InputMsg
   4. OutputMsg
