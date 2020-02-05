package org.avanish;

import org.junit.Assert;
import org.junit.Test;

public class TestSentenceValidatorImpl {
    @Test
    public void testWhenStringIsNull_False(){
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence(null));
    }

    @Test
    public void testWhenStringIsEmpty_False(){
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence(""));
    }

    @Test
    public void testWhenStringHasSomeEmptySpace_False(){
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence(" "));
    }

    @Test
    public void testWhenStringLengthIsOne_False(){
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence("A"));
    }

    @Test
    public void testWhenStringStartsWithACapitalLetter_True() {
        Assert.assertTrue(SentenceValidatorImpl.isValidSentence("The quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    public void testWhenStringNotStartsWithACapitalLetter_False() {
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence("the quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    public void testWhenStringHaveSinglePeriodAtEnd_True() {
        Assert.assertTrue(SentenceValidatorImpl.isValidSentence("The quick brown fox said hello Mr lazy dog."));
    }

    @Test
    public void testWhenStringHaveMoreThanOnePeriod_False() {
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence("The quick brown fox said hello Mr. lazy dog."));
    }

    @Test
    public void testWhenStringHaveEvenNoOfQuotes_True() {
        Assert.assertTrue(SentenceValidatorImpl.isValidSentence("The quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    public void testWhenStringHaveOddNoOfQuotes_False() {
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence("The quick brown fox said hello Mr lazy dog\"."));
    }

    @Test
    public void testWhenStringContainsInvalidNumbers_False() {
        Assert.assertFalse(SentenceValidatorImpl.isValidSentence("One lazy dog is too few, 12 11 10 is too many."));
    }

    @Test
    public void testWhenStringContainsValidNumbers_True() {
        Assert.assertTrue(SentenceValidatorImpl.isValidSentence("One lazy 34 54 dog is too few, -13 is too 13 many."));
    }

}

