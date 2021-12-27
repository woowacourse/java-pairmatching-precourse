package pairmatching;

public class FunctionOption {
    enum Name {
        MATCH("페어 매칭"),
        SEARCH("페어_조회"),
        INIT("페어_초기화"),
        QUIT("종료");

        private final String name;

        Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    enum Number {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        QUIT("Q");

        private final String number;

        Number(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }
    }
}
