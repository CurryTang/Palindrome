public class Palindrome{
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> dc = new LinkedListDeque<Character>();
        for(char c: word.toCharArray()){
            dc.addLast(c);
        }
        if (dc.isEmpty()){
            return null;
        }
        return dc;
    }

    public static boolean isPalindrome(String word){
        if (word == null || word == ""){
            return false;
        }
        Deque<Character> dc = wordToDeque(word);
        int length = dc.size();
        for(int i = 0;i < length / 2;i++){
            int j = length - 1 - i;
            if (dc.get(i) != dc.get(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOffByOne(String word){
        if (word == null || word == ""){
            return false;
        }
        Deque<Character> dc = wordToDeque(word);
        int length = dc.size();
        for(int i = 0;i < length / 2;i++){
            CharacterComparator cc = new OffByOne();
            int j = length - i - 1;
            if (!cc.equalChars(dc.get(i), dc.get(j))){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOffByN(String word, int n){
        if (word == null || word == ""){
            return false;
        }
        Deque<Character> dc = wordToDeque(word);
        int length = dc.size();
        for(int i = 0;i < length / 2;i++){
            CharacterComparator cc = new OffByN(n);
            int j = length - i - 1;
            if (!cc.equalChars(dc.get(i), dc.get(j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abbba"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abcd"));
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindromeOffByOne("flake"));
        System.out.println(isPalindromeOffByOne("aaaaa"));
        System.out.println(isPalindromeOffByN("flake", 1));
        System.out.println(isPalindromeOffByN("aaaaa", 0));
    }
}