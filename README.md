# 숫자 야구 게임
 
## 기능 요구사항 
 1. 컴퓨터는 1~9까지 서로 다른 임의의 수 3개를 생성
 2. 플레이어에게 3개의 숫자를 입력 받고 컴퓨터 숫자와 비교하여 힌트를 출력한다. 
 3. 이 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 맞추면 게임 종료 한다. 
 4. 게임을 종료 후 다시 시작하거나 완전히 종료할 수 있다. 
 5. 사용자가 잘못된 값을 입력하면 [ERROR]로 시작하는 에러메세지 출력하고 게임을 계속 진행시킨다. 
 
 ## 힌트 
  | 상태 | 내용 | 예시 |
  |---|---|---|
  |스트라이크|같은 수 and 같은 자리| 컴퓨터 : 426 / 입력 : 425 -> 2 스트라이크|
  |볼|같은 수 or 같은 자리| 컴퓨터 : 426 / 입력 : 452 -> 1 스트라이크 1 볼 |
  |낫싱|해당 안됨| 컴퓨터 : 426 / 입력 : 135 -> 낫싱|
  
 ## 제약사항
 - 시작점은  baseball.Application의 main()으로 한다. 
 - JDK 8 버전에서 실행가능해야 한다. 
 - JDK에서 기본 제공하는 Random, Scanner API 대신 nextstep.utils 패키지에서 제공하는 Randoms, Console API를
   활용해 구현해야 한다.
 - 프로그램 구현을 완료했을 때 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
 - [자바 코드 컨벤션](https://naver.github.io/hackday-conventions-java/) 을 지키면서 프로그래밍 한다. 
 - indent depth를 2가 넘지 않도록 구현한다. 
 - stream api를 사용하지 않고 구현해야한다. 단, 람다는 사용 가능하다. 
 - else 예약어를 쓰지 않는다.
 - 함수의 길이가 10라인을 넘어가지 않도록 구현한다. 
 - 도메인 로직에 단위테스트를 구현해야 한다. 단 UI 로직은 제외. 
 
 