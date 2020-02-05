package org.avanish;

import java.util.Scanner;

public class SentenceValidatorMainClass {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String rawSentence = scanner.nextLine();
        SentenceValidatorImpl sentenceValidator = new SentenceValidatorImpl();
        System.out.println(sentenceValidator.isValidSentence(rawSentence));
    }
}

