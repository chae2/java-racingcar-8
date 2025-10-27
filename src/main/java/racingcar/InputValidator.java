package racingcar;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public void determineCarName(String carNames){
        validateNotEmpty(carNames);
        validateFormat(carNames);
        validateNoTrailingComma(carNames);
        String[] names = carNames.split(",");
        validateIndividualNames(names);
    }

    private void validateNotEmpty(String carName){
        if(carName == null || carName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

    private void validateFormat(String carNames) {
        String regexAlphaCommaOnly = "^[a-zA-Z,]+$";
        if (!carNames.matches(regexAlphaCommaOnly)) {
            throw new IllegalArgumentException("자동차 이름은 알파벳과 쉼표(,)로만 구성되어야 합니다.");
        }
    }

    private void validateNoTrailingComma(String carNames) {
        if (carNames.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름이 쉼표(,)로 끝날 수 없습니다.");
        }
    }

    private void validateIndividualNames(String[] names) {
        for (String name : names) {
            validateName(name);
        }
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있을 수 없습니다. (쉼표가 연속으로 입력됨)");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다. [오류: " + name + "]");
        }
    }

    public int validatePositiveInteger(String input){
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("값이 입력되지 않았습니다. 숫자를 입력해주세요.");
        }
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 유효한 숫자가 아닙니다: " + input);
        }
        if (number <= 0) { // 인덴트 1
            throw new IllegalArgumentException("시도 횟수는 0보다 큰 숫자여야 합니다."); // 인덴트 2
        }
        return number;
    }

}
