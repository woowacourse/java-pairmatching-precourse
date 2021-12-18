package pairmatching.play;

public class PlayModel {

    public boolean playPairProgrammming(String input) {
        if(input.equals("1")) {
            game1();
        }
        if(input.equals("2")) {
            game2();
        }
        if(input.equals("3")) {
            game3();
        }
        if(input.equals("Q")) {
            return true;
        }
        return false;
    }

    public void game1() {
        System.out.println("1번게임 시작");
        System.out.println();
    }

    public void game2() {
        System.out.println("2번게임 시작");
        System.out.println();
    }

    public void game3() {
        System.out.println("3번게임 시작");
        System.out.println();
    }
}
