public class Main {
    public static void main(String[] args) {

        /*
         * Creating test cases for the anagram checker
         * We create an array of Anagram objects, each with a name, expected result, and two strings to compare
         */
        AnagramTest[] anagramTests = new AnagramTest[]{
                new AnagramTest("swap letters letters in place are anagram",
                        true, "restful", "fluster"
                ),
                new AnagramTest("swap words together are anagram",
                        true, "forty over", "over forty"
                ),
                new AnagramTest("special letters ignored and accepted as anagram",
                        true, "M", "m"),
                new AnagramTest("accept case insensitive letters as anagram",
                        true, "EviL", "vile"
                ),
                new AnagramTest("null letters are not anagram",
                        false, null, null
                ),
                new AnagramTest("empty strings are not anagram",
                        true, "", ""
                ),
                new AnagramTest("whitespace strings are not anagram",
                        true, " ", " "
                ),
                new AnagramTest("non-ascii equal letters are anagram",
                        true, "wällte änderung", "ändewällterung"
                ),
                new AnagramTest("different length strings are not anagrams",
                        false, "restful", "flustered"
                ),
                new AnagramTest("same characters but different counts are not anagrams",
                        false, "level", "levelled"
                ),
                new AnagramTest("strings with different characters are not anagrams",
                        false, "restful", "flusterous"
                ),
                new AnagramTest("strings with spaces and punctuation are anagrams",
                        true, "A Santa at NASA", "NASA at a Santa"
                ),
                new AnagramTest("strings with same characters but different cases are anagrams",
                        true, "Restful", "Fluster"
                ),
                new AnagramTest("strings with same characters but in different order are anagrams",
                        true, "Tom Marvolo Riddle", "I am Lord Voldemort"
                ),
                new AnagramTest("string with different punctuations are anagrams",
                        true, "The Morse Code", "Here come dots!"
                ),
                new AnagramTest("string with different punctuations complex form are anagrams",
                        true, "Here come sider dots, come you may consider dots Here", "Here come siderdots, comeyo,mauy,Here!$considerdots"
                ),
                new AnagramTest("strings with same characters but different cases and punctuation are anagrams",
                        true, "A Santa at NASA!", "NASA at a Santa"
                ),
                new AnagramTest("strings with same characters but different cases, punctuation, and whitespace are anagrams",
                        true, "A Santa at NASA!", "NASA at a Santa "
                ),
                new AnagramTest("strings with same characters but different cases, punctuation, whitespace, and digits are anagrams",
                        true, "A Santa at NASA! 123", "NASA at a Santa 321"
                ),
                new AnagramTest("strings with same characters but different cases, punctuation, whitespace, digits, and symbols are anagrams",
                        true, "rich-chosen goofy cult! 123 $%^&*", "Rich-chosen 321 goofycult! *&^%$"
                )
        };

        var anagramChecker = new ArrayAnagramChecker();

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
}