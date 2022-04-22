package pt.ua.deti.lei.tqs.covid_track.model;

import java.util.List;

public class Average {

    private List<Integer> numbers;

    private Average() {}

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer get() {
        int sum = 0;

        for (Integer number :
                this.numbers) {
            sum += number.intValue();
        }
        return sum/this.numbers.size();
    }

}
