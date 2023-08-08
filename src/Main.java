public class Main {
    public static void main(String[] args) {
        var anagramChecker = new ArrayAnagramChecker();

        AnagramTest[] anagramTests = loadTests();
        // We then loop through the array and compare the result of the anagram strategy with the expected result
        for (AnagramTest test : anagramTests) {
            boolean result = anagramChecker.areAnagrams(test.text1(), test.text2());
            if (result != test.expected()) {
                System.out.println("Failed: " + test.name());
                System.out.println("Expected: " + test.expected() + ", but got: " + result);
            } else {
                System.out.println("Passed: " + test.name());
            }
        }
    }

    private static AnagramTest[] loadTests() {
        /*
         * Creating test case for the anagram checker
         * We create an array of Anagram objects, each with a name, expected result, and two strings to compare
         */
        return new AnagramTest[]{
                new AnagramTest("texts with same characters but different order are anagram",
                        true, "restful", "fluster"
                ),
                new AnagramTest("texts with different characters but different order are anagram",
                        true, "restful", "fluster"
                ),
                new AnagramTest("texts with same but swapped words are anagram",
                        true, "forty over", "over forty"
                ),
                new AnagramTest("texts with same characters but different case are anagram",
                        true, "M", "m"),
                new AnagramTest("texts with different case and different order are anagram",
                        true, "EviL", "vile"
                ),
                new AnagramTest("texts with null are not anagram",
                        false, null, null
                ),
                new AnagramTest("texts with whitespaces are not anagram",
                        true, " ", "  "
                ),
                new AnagramTest("texts with same non-ascii characters but different order are anagram",
                        true, "wöllte änderung", "öndewällterung"
                ),
                new AnagramTest("texts with different lengths are not anagrams",
                        false, "restful", "estful"
                ),
                new AnagramTest("texts with same characters but different lengths are not anagrams",
                        false, "level", "levelled"
                ),
                new AnagramTest("texts with different characters but same length are not anagrams",
                        false, "iosrestful", "flusterous"
                ),
                new AnagramTest("texts with same characters,spaces, punctuation but different word order are anagrams",
                        true, "A Santa at NASA!", "NASA at a Santa!"
                ),
                new AnagramTest("texts with same characters but different case are anagrams",
                        true, "Restful", "Fluster"
                ),
                new AnagramTest("texts with same characters,space but in different order are anagrams",
                        true, "Tom Marvolo Riddle", "I am Lord Voldemort"
                ),
                new AnagramTest("texts with same characters,space, punctuations and special characters but different case are anagrams",
                        true, "Here come sider dots, come you may consider dots Here!", "Here come siderdots comeyo mauy,Here!considerdots"
                ),
                new AnagramTest("texts with same characters,punctuation but different case are anagrams",
                        true, "A Santa at NASA!", "NASA at a Santa!"
                ),
                new AnagramTest("texts with same characters,punctuation,and whitespace but different case are anagrams",
                        false, "A Santa at NASA!", "NASA at a Santa "
                ),
                new AnagramTest("texts with same characters,punctuation,whitespace,digits but different case are anagrams",
                        true, "A Santa at NASA! 321", "NASA at a Santa 321!"
                ),
                new AnagramTest("texts with same characters but different case, punctuation, whitespace, digits, but special characters are anagrams",
                        true, "rich-chosen goofy cult! 123 $%^&*", "Rich-chosen 321 goofycult! *&^%$"
                ),
                new AnagramTest("texts with same characters,punctuation,whitespace,digits,and symbols but different case are anagrams",
                        true, "rich-chosen goofy cult! 123 $%^&*", "Rich-chosen 321 goofycult! *&^%$"
                ),
                new AnagramTest("texts with only digits are anagrams",
                        true, "12321", "32121"
                ),
                new AnagramTest("texts with only digits but different numbers are not anagrams",
                        false, "12321", "12322"
                ),
                new AnagramTest("texts with only digits but different order are anagrams",
                        true, "12321111", "12321111"
                ),
                new AnagramTest("texts with complex structure,same characters,digits but ignore special characters are anagrams",
                        true, "aha!12321111;", "a1;h23a<<21111!"
                ),
        };
    }
}