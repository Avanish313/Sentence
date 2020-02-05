/*
 * Class to validate a sentence based on below rules
 * String starts with a capital letter
 * String has an even number of quotation marks
 * String ends with a period character “."
 * String has no period characters other than the last character
 * Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)
 */

package org.avanish;

import org.apache.commons.lang3.StringUtils;
import java.util.function.Predicate;

public class SentenceValidatorImpl {
    /*
    Predicate defined to check if a character is upper case
    and will be used to check if first character of the sentence
    starts with a Capital letter.
     */
    private final static Predicate<Character> capitalLetter = Character::isUpperCase;
    /*
     * Constants
     */
    private static final char period = '.';
    private static final char quote = '"';
    private static final int MIN_ALLOWED_NUMBER = 13;

    /*
     * Method to validate the input sentence.
     * First check is for null or empty string,
     * then trim and check if length > 1 and call
     * method passingAllOtherValidations
     * to perform all other validations
     * @param rawSentence input sentence in form of String
     * @return boolean true or false depending on if entered sentence is valid or not.
     */
    public static boolean  isValidSentence(String rawSentence) {
        if(StringUtils.isEmpty(rawSentence))
            return false;
        return rawSentence.trim().length()>1 && passingAllOtherValidations(rawSentence);
    }

    /*
     * Method to validate the input sentence.
     * First check if first character is a Capital letter
     * then call periodAndQuoteCheck and validateNumbers
     * methods to perform period, quote and number validations
     * @param sentence input sentence in form of String
     * @return boolean true or fasle depending on if String is valid or not.
     */
    private static boolean passingAllOtherValidations(String sentence) {
        return capitalLetter.test(sentence.charAt(0))
                && periodAndQuoteCheck(sentence)
                && validateNumbers(sentence);
    }

    /*
     * Method to check if sentence ends with a period
     * and does not contain any other period.
     * To check if no of quotes is even
     * @param sentence to validate
     * @return boolean true or false depending if the sentence is valid or not.
     */
    private static boolean periodAndQuoteCheck(String sentence){
        char[] sentenceCharArray = sentence.toCharArray();
        if (sentenceCharArray[sentenceCharArray.length - 1] != period) {
            return false;
        }
        boolean isEvenQuotes = true;
        for (int i = 0; i < sentenceCharArray.length -1; i++) {
            if(sentenceCharArray[i]== period){
                return false;
            }
            if (sentenceCharArray[i] == quote) {
                isEvenQuotes = !isEvenQuotes;
            }
        }
        return isEvenQuotes;
    }

    /*
     * Method to validate if string contains any number smaller that 13
     * This method will use java.util.regex to replace all characters excpet
     * numbers, so any negative numbers like -14 will be considered 14 and will return true
     * since its equal to or greater than number 13.
     * If required we can handle the negative case by using regex -?(optional).
     * @param sentence to validate
     * @return boolean true or false depending on if sentence contains
     * any number smaller than 13.(except negative numbers)
     */
    private static boolean validateNumbers(String sentence){
        String stringWithNumbers = sentence.replaceAll("\\D+", " ");
        //trimming to remove the empty spaces from start and end.
        stringWithNumbers = stringWithNumbers.trim();
        if (stringWithNumbers.isEmpty()) {
            return true;
        }
        int lowestNumber = MIN_ALLOWED_NUMBER;
        for (String number : stringWithNumbers.split(" ")) {
            lowestNumber = Math.min(lowestNumber, Integer.parseInt(number));
            //if any one lowest number found break the for loop and return false
            if(lowestNumber<MIN_ALLOWED_NUMBER)
                break;
        }
        return lowestNumber >= MIN_ALLOWED_NUMBER;
    }
}


