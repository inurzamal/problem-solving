package org.example.practices;

public class CountGivenCharacter {

    static int characterOccurence(String str, char c){
        int count = 0;

        for (int i = 0; i<str.length(); i++){
            if (str.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = characterOccurence("Hello", 'l');
        System.out.println(count);
    }
}
