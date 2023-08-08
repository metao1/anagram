import java.text.Normalizer;
import java.util.Set;

/**
 * This class implements the AnagramChecker interface using array-based approach.
 * <p>
 * The array-based approach uses an array to store the frequency of each character in Unicode.
 * </p>
 */
class ArrayAnagramChecker implements AnagramChecker {

    // The starting character in Unicode
    private static final char START_CHAR = 33;// (exclamation mark)

    // The number of characters in Unicode plus numbers and punctuation
    private static final int CHARACTER_LIMIT = 280;//256(unicode) + 10 (0-9) + 14 (punctuation)

    private static final Set<Integer> punctuationCodes = Set.of(
            0x002C, // Comma
            0x002E, // Period
            0x003F, // Question Mark
            0x0021, // Exclamation Mark
            0x003B, // Semicolon
            0x003A, // Colon
            0x002D, // Hyphen-Minus
            0x0027, // Apostrophe
            0x0022, // Quotation Mark (Double)
            0x0028, // Parenthesis Open
            0x0029, // Parenthesis Close
            0x005B, // Square Bracket Open
            0x005D, // Square Bracket Close
            0x007B, // Curly Brace Open
            0x007D  // Curly Brace Close
    );

    @Override
    public boolean areAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return false;
        }

        text1 = normalizeText(text1);
        text2 = normalizeText(text2);

        // Frequency of characters in Unicode
        int[] frequency = new int[CHARACTER_LIMIT];
        char[] charactersText1 = text1.toCharArray();
        char[] charactersText2 = text2.toCharArray();

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

    // Remove accents and convert to lowercase
    private static String normalizeText(String text) {
        // Remove accents and convert to lowercase
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\s+", "")
                .toLowerCase();
    }

    // Count the frequency of each character in the text
    private void countCharacterFrequency(char[] characters, int[] frequency, int increment) {
        for (char ch : characters) {
            if (!isValidCharacter(ch)) {
                continue;
            }
            int index = ch - START_CHAR;
            // If the ch is uppercase, consider it as lowercase
            if (index < 0) {
                index += 32;
            }
            frequency[index] += increment;
        }
    }

    // Checks if the character is either a letter, number or punctuation
    private boolean isValidCharacter(char ch) {
        return (ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= '0' && ch <= '9') ||
                punctuationCodes.contains((int) ch);
    }
}