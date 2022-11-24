package java3rd.ch14.lambda;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student4 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student4(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getHak() {
        return hak;
    }

    public void setHak(int hak) {
        this.hak = hak;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점",
                name, isMale ? "남" : "여", hak , ban ,score);
    }

    // groupingBy() 에서 사용
    enum Level {HIGH, MID, LOW } // 성적을 상, 중, 하 세 단계로 분류류
}

public class Exercise14_8 {
    public static void main(String[] args) {
        Student4[] stuArr = {
                new Student4("나자바", true, 1, 1, 300),
                new Student4("김지미", false, 1, 1, 250),
                new Student4("김자바", true, 1, 1, 200),
                new Student4("이지미", false, 1, 2, 150),
                new Student4("남자바", true, 1, 2, 100),
                new Student4("안지미", false, 1, 2, 50),
                new Student4("황지미", false, 1, 3, 100),
                new Student4("강지미", false, 1, 3, 150),
                new Student4("이자바", true, 1, 3, 200),
                new Student4("나자바", true, 2, 1, 300),
                new Student4("김지미", false, 2, 1, 250),
                new Student4("김자바", true, 2, 1, 200),
                new Student4("이지미", false, 2, 2, 150),
                new Student4("남자바", true, 2, 2, 100),
                new Student4("안지미", false, 2, 2, 50),
                new Student4("황지미", false, 2, 3, 100),
                new Student4("강지미", false, 2, 3, 150),
                new Student4("이자바", true, 2, 3, 200)
        };

        Map<Boolean, Map<Boolean, Long>> studentStream = Stream.of(stuArr)
                .collect(
                        Collectors.partitioningBy(
                            Student4::isMale,
                                Collectors.partitioningBy(s -> s.getScore() < 150
                                , Collectors.counting())
                        )
                        );
    }
}
