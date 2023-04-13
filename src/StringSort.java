// Взяв за основу материал классной работы,
// написать алгоритм сортировки слиянием для строк (используйте метод compareTo()).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSort {

  public static void main(String[] args) {
    String test = "Добро Глаголь Аз Веди Есть Буки";
    sortString(test);
    System.out.println(test);
  }

  /**
   * Class find all words in the String, using gap as separator, and will return a string with
   * alphabetically sorted words
   *
   * @param initial String
   * @return sort String
   */
  public static String sortString(String initial) {
    //I think, that time complexity for method .split() is O(n), because,
    // we need one time go through all String. However, we also should find .length(), it is one
    // more additional round. I believe, that Java developers do that in 2 separate cycle:)
    String[] disorderString = initial.split(" ");
    List<String> disorderList = new ArrayList<>(Arrays.asList(disorderString));

    List<String> orderString = sortArrayString(disorderList);

    // complexity O(n) - one cycle with for
    String result = null;
    String gap = " ";
    for (String word : orderString) {
      result = word + gap;
    }

    return result;
  }

  private static List<String> sortArrayString(List<String> words) {
    //guardian condition for escape from recursion
    if (words.size() < 2) {
      return words;
    }

    //separation for 2 different arrays
    int mid = words.size() / 2;
    //hope, that it will be also O(n)
    List<String> left = words.subList(0, mid);
    List<String> right = words.subList(mid, words.size());

    left = sortArrayString(left);
    right = sortArrayString(right);

    return merge(left, right);
  }

  private static List<String> merge(List<String> wordA, List<String> wordB) {
    List<String> result = null;
    int i1 = 0;
    int i2 = 0;

    while (i1 < wordA.size() && i2 < wordB.size()) {
      String first = wordA.get(i1);
      String second = wordB.get(i2);
      if (first.compareTo(second) < 1) {
        // on that place, I understand, that String[] not so easy to add new element and
        // I must to updating all methods :)
        result.add(first);
        ++i1;
      } else {
        result.add(second);
        ++i2;
      }
    }

    while(i1 < wordA.size()) {
      result.add(wordA.get(i1));
      ++i1;
    }

    while(i2 < wordB.size()) {
      result.add(wordB.get(i2));
      ++i2;
    }

    return result;
  }
}
