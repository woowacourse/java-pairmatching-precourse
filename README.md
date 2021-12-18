# 미션 - 페어매칭관리 애플리케이션

## 기능 구현 목록

- Architecture : MVC Model

1. Model
   - Crew
   - CrewList
   - Matcher
   - Saver

2. View
   - InputView
   - MenuInputView
   - InitialInputView
   - MatchingInputView
   - FileInputView
   - SeekInputView
   
3. Controller
   - SeekController
   - MatchingController
   - InitialController

4. Utils
   - Validator
   - Course (enum)
   - Level (enum)
   - Messages

- 기능 목록
  - [] 파일을 불러온 후 parsing하는 기능
  - [] 매칭하는 기능
  - [] 사용자에게 초기 화면을 띄우는 기능
  - [] 이미 매칭이 되어있는지 확인하는 기능
  - [] 페어를 계속 찾을 수 있는지 없는지 확인하는 기능
  - [] 각 페어가 매칭된 기록을 저장하는 기능
  - [] 사용자의 입력을 가져오는 기능
  - [] 사용자에게 요청된 작업이 완료되었다는 화면을 띄우는 기능
