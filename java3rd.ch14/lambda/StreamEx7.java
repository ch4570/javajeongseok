package java3rd.ch14.lambda;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student1 {
    String name;
    boolean isMale;     // 성별
    int hak;            // 학년
    int ban;            // 반
    int score;

    Student1(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban ,score);
    }

    // groupingBy() 에서 사용
    enum Level { HIGH, MID, LOW } // 성적을 상, 중 ,하 세 단계로 분류류
}

public class StreamEx7 {
    public static void main(String[] args) {
        Student1[] stuArr = {
                new Student1("나자바", true, 1, 1, 300),
                new Student1("김지미", false, 1, 1, 250),
                new Student1("김자바", true, 1, 1, 200),
                new Student1("이지미", false, 1, 2, 150),
                new Student1("남자바", true, 1, 2, 100),
                new Student1("안지미", false, 1, 2, 50),
                new Student1("황지미", false, 1, 3, 100),
                new Student1("강지미", false, 1, 3, 150),
                new Student1("이자바", true, 1, 3, 200),

                new Student1("나자바", true, 2, 1, 300),
                new Student1("김지미", false, 2, 1, 250),
                new Student1("김자바", true, 2, 1, 200),
                new Student1("이지미", false, 2, 2, 150),
                new Student1("남자바", true, 2, 2, 100),
                new Student1("안지미", false, 2, 2, 50),
                new Student1("황지미", false, 2, 3, 100),
                new Student1("강지미", false, 2, 3, 150),
                new Student1("이자바", true, 2, 3, 200),

        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student1>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student1::isMale));

        List<Student1> maleStudent = stuBySex.get(true);
        List<Student1> femaleStudent = stuBySex.get(false);

        for(Student1 s : maleStudent) System.out.println(s);
        for(Student1 s : femaleStudent) System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생 수) %n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student1::isMale, counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student1>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student1::isMale,
                        maxBy(comparingInt(Student1::getScore))
                ));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        Map<Boolean, Student1> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student1::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student1::getScore)), Optional::get
                        )
                ));

        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점이하)%n");

        Map<Boolean, Map<Boolean, List<Student1>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Student1::isMale,
                        partitioningBy(s -> s.getScore() <= 100))
                );
        List<Student1> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student1> failedFemailStu = failedStuBySex.get(false).get(true);

        for(Student1 s : failedMaleStu) System.out.println(s);
        for(Student1 s : failedFemailStu) System.out.println(s);
    }
}
