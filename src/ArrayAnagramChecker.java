/**
 * This class implements the AnagramChecker interface using array-based approach.
 * <p>
 * The array-based approach uses an array to store the frequency of each character in Unicode.
 * </p>
 */
class ArrayAnagramChecker implements AnagramChecker {

    // The starting character in Unicode
    private static final char START_CHAR = 'a';

    // The number of characters in Unicode to support
    private static final int CHARACTER_LIMIT = 256;

    @Override
    public boolean areAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return false;
        }

        // Trim and convert the input strings to lowercase
        text1 = text1.replaceAll("\\s+", "").toLowerCase();
        text2 = text2.replaceAll("\\s+", "").toLowerCase();

        if (text1.length() != text2.length()) {
            return false;
        }

        if (text1.equals(text2)) {
            return true;
        }

        // Frequency of characters in Unicode
        int[] frequency = new int[CHARACTER_LIMIT];
        char[] charactersText1 = text1.toCharArray();
        char[] charactersText2 = text2.toCharArray();

        // Count the frequency of each character in text1
        for (char character : charactersText1) {
            frequency[character - START_CHAR]++;
        }

        for (char character : charactersText2) {
            frequency[character - START_CHAR]--;
        }

        // Check if the frequency of each character is zero
        // If the frequency of all characters are zero, then the strings are anagrams
        for (int freq : frequency) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}