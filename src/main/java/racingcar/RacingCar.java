package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public String name;
    public int dist;

    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
    }

    public void getName(String carName){
        this.name = carName;
    }

    public void moveForward(){
        dist = dist+1;
    }

    public void attemptMoveForward(){
        int random = Randoms.pickNumberInRange(0,9);
        if (random>=4) moveForward();
    }
}
