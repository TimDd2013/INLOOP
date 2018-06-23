public class Leet {
  public static String toLeet(String normal) {
    normal = normal.replaceAll("elite", "1337");
    normal = normal.replaceAll("cool", "k3wl");
    normal = normal.replaceAll("!", "!!!11");
    normal = normal.replaceAll("ck", "xx");
    normal = normal.replaceAll("ers", "0rz");
    normal = normal.replaceAll("er", "0rz");
    normal = normal.replaceAll("en", "n");
    normal = normal.replaceAll("e", "3");
    normal = normal.replaceAll("t", "7");
    normal = normal.replaceAll("o", "0");
    normal = normal.replaceAll("a", "@");
    return normal;
  }
  public static String[] allToLeet(String[] normals) {
    int index = normals.length;
    String[] result = new String[index];
    for (int i = 0; i < index; i++) {
      result[i] = toLeet(normals[i]);
    }
    return result;
  }
}
