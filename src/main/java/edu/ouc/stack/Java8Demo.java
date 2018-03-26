package edu.ouc.stack;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Demo {
    public static void main(String[] args) {

        testStream();
    }

    static class Person {
        int id;
        String name;
        int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static void testLambda() {
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(a -> System.out.println(a));
        List<Person> list = Arrays.asList(new Person(1, "aa", 33), new Person(2, "bb", 12)
                , new Person(3, "cc", 23));
        int total = list.stream().filter(p -> p.age > 20)
                .mapToInt(p -> p.age)
                .sum();
        System.out.println("total:" + total);

        list.sort((p1, p2) -> p1.age - p2.age);
        list.forEach(a -> System.out.println("name:" + a.name + ",age:" + a.age));
        Collection c = null;

    }

    public static void testOptional() {
        Optional<Person> person = Optional.empty();
        System.out.println(person + ",name:" + person.isPresent());
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }

    public static void testStream() {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        // 1.所有状态为OPEN的任务一共有多少分数
        int total = tasks.stream()
                .parallel()
                .filter(t -> t.status == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        // 2. 统计OPEN和CLOSE状态的任务的占比
        Map<Status, List<Task>> map = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(map);
        System.out.println("total:" + total);

        try {
            File file = new File("pom.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            br.lines()
                    .filter(line -> line.contains("groupId"))
                    .map(line -> {
                        line = line
                                .trim()
                                .replaceAll("(<|</)groupId>", "");
                        return line;
                    }).collect(Collectors.toSet())
                    .forEach(line -> System.out.println(line));

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));
        System.out.println("s:" + s + ",l:" + l.toString());
    }

    private enum Status {
        OPEN, CLOSED
    }

    ;

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }
}
