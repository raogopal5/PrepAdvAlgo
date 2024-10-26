package prep.google.interview;

import java.util.Arrays;
import java.util.Comparator;

public class RestarantReview {

    class Solution {
        class Pair {
            int first, second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;

            public boolean hasWord(String w) {
                TrieNode nextNode = this;
                for (int i = 0; i < w.length(); i++) {
                    nextNode = nextNode.children[w.charAt(i) - 'a'];
                    if (nextNode == null) {
                        return false;
                    }
                    if (i == w.length() - 1) {
                        return nextNode.isEnd;
                    }
                }
                return false;
            }

            public void addWord(String w) {
                TrieNode nextNode = this;
                for (int i = 0; i < w.length(); i++) {
                    int nextIndex = w.charAt(i) - 'a';
                    if (nextNode.children[nextIndex] == null) {
                        nextNode.children[nextIndex] = new TrieNode();
                    }
                    nextNode = nextNode.children[nextIndex];
                    if (i == w.length() - 1) {
                        nextNode.isEnd = true;
                        return;
                    }
                }
            }
        }

        String[] orderReviews(String[] reviews, String[] goodWords) {
            String[] output = new String[reviews.length];
            TrieNode root = new TrieNode();
            for (int i = 0; i < goodWords.length; i++) {
                root.addWord(goodWords[i]);
            }
            Pair[] goodness = new Pair[reviews.length];
            int goodnessIndx = 0;
            for (int i = 0; i < reviews.length; i++) {
                String review = reviews[i];
                int numGoodWords = 0;
                int s = 0;
                for (int j = 0; j < review.length(); j++) {
                    if (review.charAt(j) == ' ') {
                        if (root.hasWord(review.substring(s, j))) {
                            numGoodWords++;
                        }
                        s = j + 1;
                    }
                }
                if (root.hasWord(review.substring(s, review.length()))) {
                    numGoodWords++;
                }
                goodness[goodnessIndx++] = (new Pair(numGoodWords, i));
            }
            Arrays.sort(goodness, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    if (a.first < b.first) {
                        return 1;
                    }
                    if (a.first == b.first && a.second > b.second) {
                        return 1;
                    }
                    return -1;
                }
            });
            for (int i = 0; i < reviews.length; i++) {
                output[i] = reviews[goodness[i].second];
            }
            return output;
        }
    }
}
