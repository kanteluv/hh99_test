import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    static class GetRandom {
        Random random = new Random();
        int[] getNum = new int[3];
        int idx = 0;

        private boolean chkRandomVal(int[] chk, int idx) {
            for(int i = 0; i < chk.length; i++) {
                if(chk[i] == idx)
                    return true;
            }
            return false;
        }

        private void getRandomVal() {
            for(int i = 0; i< getNum.length;i++) {
                do {
                    idx = (int)(Math.random()*10);
                }while(chkRandomVal(getNum, idx));
                getNum[i] = idx;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetRandom getRandom = new GetRandom();
        int[] randomData = new int[3];
        int[] answer = new int[3];
        int getData = 0;
        int count = 0;
        int strikeCnt = 0;
        int ballCnt = 0;
        int loopCnt = 0;
        boolean chk_success = true;

        getRandom.getRandomVal();  //난수배열 생성
        randomData = getRandom.getNum;

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        while (chk_success) {
            while (count < 3) {
                System.out.println(count + 1 + "번째 숫자를 입력하십시오.");
                getData = scanner.nextInt();
                if (getData >= 10) {
                    System.out.println("숫자값은 10 이상은 안됩니다. 다시 입력하세요.");
                } else {
                    answer[count] = getData;
                    count++;
                }
            }

            System.out.println("입력하신 값은 " + Arrays.toString(answer));
            System.out.println("랜덤값은 " + Arrays.toString(randomData));

            for (int i = 0; i < answer.length; i++) {
                //반복문 처음에는 S 유무를 체크
                if (answer[i] == randomData[i]) {
                    strikeCnt++;
                } else {
                    for (int j = 0; j < answer.length; j++) {
                        //두번째 반복에는 B 유무를 체크
                        if (answer[i] == randomData[j])
                            ballCnt++;
                    }
                }
            }

            System.out.println("스트라이크 카운트 : " + strikeCnt);
            System.out.println("볼 카운트 : " + ballCnt);

            if (strikeCnt == 0)
                System.out.println(ballCnt + "B");
            else if (ballCnt == 0)
                System.out.println(strikeCnt + "S");
            else
                System.out.println(ballCnt + "B" + strikeCnt + "S");

            loopCnt++;

            if(strikeCnt == 3) {
                chk_success = false;
                strikeCnt = 0;
                ballCnt = 0;
                count = 0;
                System.out.println(loopCnt + "번만에 맞히셨습니다. \n 게임을 종료합니다.");
            }
            else {
                chk_success = true;
                strikeCnt = 0;
                ballCnt = 0;
                count = 0;
            }
//
        }
    }
}
