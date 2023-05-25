package quiz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    File quizJson;

    public Quiz(String fileName) {
//        String file = Objects.requireNonNull(this.getClass().getClassLoader()
//                .getResource(fileName)).getFile();
        quizJson = new File(fileName);
    }

    public void displayQuestions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Question> question = mapper.readValue(quizJson,
                new TypeReference<>() {});

        question.stream()
                .map(Question::getPytanie)
                .forEach(System.out::println);
    }

    public void play() throws IOException {
        int punkty = 0;
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(quizJson,
                new TypeReference<>() {});

        for (Question question : questions) {
            System.out.println(question.getPytanie());
            System.out.println("A: " + question.getA());
            System.out.println("B: " + question.getB());
            System.out.println("C: " + question.getC());
            System.out.println("D: " + question.getD());
            System.out.println("Podaj odpowiedź (a, b, c, d): ");

            String answer = scanner.nextLine();

            if(question.getPrawidlowaOdpowiedz().equals(answer)) {
                System.out.println("To prawidłowa odpowiedź");
                punkty++;
            } else {
                System.out.println("Błędna odpowiedź. Prawidłowa to: " + question.getPrawidlowaOdpowiedz());
            }
        }
        System.out.println("Zdobyłeś " + punkty + " punktów!");
        scanner.close();
    }
}