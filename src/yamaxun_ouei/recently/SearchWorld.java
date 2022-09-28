package yamaxun_ouei.recently;

public class SearchWorld {
    int add(String searchWord, String resultWord) {
        int searchIndex = 0, resultIndex = 0;
        while (searchIndex < searchWord.length() && resultIndex < resultWord.length()) {
            if (searchWord.charAt(searchIndex) == resultWord.charAt(resultIndex)) {
                resultIndex++;
            }
            searchIndex++;
        }
        return resultWord.length() - resultIndex;
    }
}
