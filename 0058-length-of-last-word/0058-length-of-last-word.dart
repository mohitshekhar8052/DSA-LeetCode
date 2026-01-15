class Solution {
  int lengthOfLastWord(String s) {
    int i = s.length-1;
    int count = 0;

    while(i>=0 && s[i] == ' '){
        i--;
    }
    while(i>=0 && s[i]!=' '){
        count++;
        i--;
    }
    return count;
  }
}