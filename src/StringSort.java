// Взяв за основу материал классной работы,
// написать алгоритм сортировки слиянием для строк (используйте метод compareTo()).

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
    String[] orderString = sortArrayString(disorderString);

    String result = null;
    String gap = " ";
    for(String elem : orderString) {
      result = elem + gap;
    }

    return result;
  }

  private static String[] sortArrayString(String[] disorderString) {
    String[]  orderString = disorderString;
    return orderString;
  }
}
