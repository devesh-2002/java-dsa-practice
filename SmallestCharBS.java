public class SmallestCharBS {
    public static void main(String[] args){
  //
       
    }
    public char nextGreatestLetter(char[] letters, char target) {
        // but what if the target is greater than the greatest number in the letters
        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else if (target > letters[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return letters[mid];
            }
        }
        return letters[start%letters.length];
    }
    }
