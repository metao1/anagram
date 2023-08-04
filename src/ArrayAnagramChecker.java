/**
 * This class implements the AnagramChecker interface using array-based approach.
 * <p>
 * The array-based approach uses an array to store the frequency of each character in Unicode.
 * </p>
 */
class ArrayAnagramChecker implements AnagramChecker {

    // The starting character in Unicode
    private static final char START = 'a';

    // The number of characters in Unicode to support
    private static final int CHARACTER_LIMIT = 256;
    private static final int SPACE_CHAR = 32;

    @Override
    public boolean areAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return false;
        }

        if (text1.equals(text2)) {
            return true;
        }

        // Frequency of characters in Unicode
        int[] frequency = new int[CHARACTER_LIMIT];
        char[] charactersText1 = text1.toCharArray();
        char[] charactersText2 = text2.toCharArray();

        // Count the frequency of each character in text1 and text2
        countCharacterFrequency(charactersText1, frequency, 1);
        countCharacterFrequency(charactersText2, frequency, -1);

        // Check if the frequency of each character is zero
        // If the frequency of all characters are zero, then the strings are anagrams
        for (int freq : frequency) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }

    private void countCharacterFrequency(char[] characters, int[] frequency, int increment) {
        for (char character : characters) {
            if (character != SPACE_CHAR) {
                int index = character - START;
                // If the character is uppercase, consider it as lowercase
                if (index < 0) {
                    index += 32;
                }
                frequency[index] += increment;
            }
        }
    }
}