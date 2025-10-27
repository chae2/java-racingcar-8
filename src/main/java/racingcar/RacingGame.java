package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    List<RacingCar> participants;
    int times;

    public RacingGame(List<String> carNamesList, int times) {
        this.participants = carNamesList.stream().map(this::createRacingCar).collect(Collectors.toList());
        this.times = times;
    }

    private RacingCar createRacingCar(String carName){
        return new RacingCar(carName);
    }

    public void goRounds(){
        while (this.times > 0) {
            moveCarsInRound();
            this.times -= 1;
        }
    }

    public void moveCarsInRound(){
        for (RacingCar racingCar : this.participants) racingCar.attemptMoveForward();
        printInRound();
    }

    public void printInRound(){
        for (RacingCar racingCar : this.participants) System.out.println(racingCar.name+" : "+"-".repeat(racingCar.dist));
        System.out.println();
    }

    public void determineWinner(){
        int maxDist = findMaxDistance();
        List<RacingCar> winners = findWinners(maxDist);
        printWinners(winners);
    }

    private int findMaxDistance(){
        int maxDist = 0;
        for (RacingCar racingCar : this.participants){
            maxDist = Math.max(maxDist,racingCar.dist);
        }
        return maxDist;
    }

    private List<RacingCar> findWinners(int maxDist){
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : this.participants){
            addWinnerIfMaxDist(winners,racingCar,maxDist);
        }
        return winners;
    }

    private void addWinnerIfMaxDist(List<RacingCar> winners, RacingCar racingCar, int maxDist){
        if (racingCar.dist == maxDist){
            winners.add(racingCar);
        }
    }

    private void printWinners(List<RacingCar> winners){
        System.out.print("최종 우승자 : ");
        Iterator<RacingCar> iterator = winners.iterator();
        while (iterator.hasNext()){
            RacingCar winner = iterator.next();
            System.out.print(winner.name);
            addPunctuation(iterator);
        }
    }
    private void addPunctuation(Iterator<RacingCar> iterator){
        if (iterator.hasNext()){
            System.out.print(", ");
        } else{
            System.out.println();
        }
    }
}
