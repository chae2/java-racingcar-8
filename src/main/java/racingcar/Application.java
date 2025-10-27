package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        // 입력값 검증
        InputValidator inputValidator = new InputValidator();
        inputValidator.determineCarName(carNames);

        List<String> carNamesList = Arrays.asList(carNames.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int times = inputValidator.validatePositiveInteger(Console.readLine());

        RacingGame game = new RacingGame(carNamesList,times);

        System.out.println("\n실행 결과");

        game.goRounds();
        game.determineWinner();
    }
}
