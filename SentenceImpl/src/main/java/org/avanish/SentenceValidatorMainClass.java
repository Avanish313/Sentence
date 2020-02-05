package org.avanish;

import java.util.Scanner;

/*
 * Class having main method to call the
 * Implementing class for Sentence validation.
 */
public class SentenceValidatorMainClass {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String rawSentence = scanner.nextLine();
        SentenceValidatorImpl sentenceValidatorImpl = new SentenceValidatorImpl();
        System.out.println(sentenceValidatorImpl.isValidSentence(rawSentence));
    }
}

