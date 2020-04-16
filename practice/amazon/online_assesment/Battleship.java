package amazon.online_assesment;

import java.util.*;

/**
 * Jack plays a game of battleships with his friend Stacy. The game is played on a square map of N
 * rows, numbered from 1 to N. Each row contains N cells, labeled with consecutive English upper-case
 * letters (A, B, C, etc.). Each cell is identified by a string composed of its row number followed by its
 * column number: for example, "9C" denotes the third cell in the 9th row, and "15D" denotes the
 * fourth cell in the 15th row.
 * Jack marks the positions of all his ships on the map (which is not shown to Stacy). Ships are defined
 * by rectangles with a maximum area of 4 cells. Stacy picks map cells to hit some ships. A ship is
 * considered to be hit if at least one of its constituent cells is hit. If all of a ship's cells are hit, the ship is
 * sunk.
 * The goal is to count the number of sunk ships and the number of ships that have been hit but not
 * sunk.
 * For example, the picture below shows a map of size N = 4 with two blue ships and five hits marked
 * with the letter 'X':
 * <p>
 * image
 * <p>
 * In this example, one ship has been sunk and the other has been hit but not sunk. In the next picture,
 * the sunken ship is shown in grey and the ship that has been hit but not yet sunk appears in red:
 * <p>
 * image
 * <p>
 * The positions of ships are given as a string S, containing pairs of positions describing respectively the
 * top-left and bottom-right corner cells of each ship. Ships' descriptions are separated with commas.
 * The positions of hits are given as a string T, containing positions describing the map cells that were
 * hit: for the map in the example shown above, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A". Ships in
 * S and hits in T may appear in any order.
 * Write a function:
 * class Solution { public String solution(int N, String S, String T); }
 * that, given the size of the map N and two strings S, T that describe the positions of ships and hits
 * respectively, returns a string with two numbers: the count of sunken ships and the count of ships that
 * have been hit but not sunk, separated with a comma.
 * For instance, given N = 4, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A", your function should return
 * "1,1", as explained above.
 * Given N = 3, S = "1A 1B,2C 2C" and T = "1B", your function should return "0,1", because one ship
 * was hit but not sunk.
 * The positions of ships are given as a string S, containing pairs of positions describing respectively the
 * top-left and bottom-right corner cells of each ship. Ships' descriptions are separated with commas.
 * The positions of hits are given as a string T, containing positions describing the map cells that were
 * hit: for the map in the example shown above, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A". Ships in
 * S and hits in T may appear in any order.
 * Write a function:
 * <p>
 * class Solution { public String solution(int N, String S, String T); }
 * that, given the size of the map N and two strings S, T that describe the positions of ships and hits
 * respectively, returns a string with two numbers: the count of sunken ships and the count of ships that
 * have been hit but not sunk, separated with a comma.
 * <p>
 * For instance, given N = 4, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A", your function should return
 * "1,1", as explained above.
 * <p>
 * Given N = 3, S = "1A 1B,2C 2C" and T = "1B", your function should return "0,1", because one ship
 * was hit but not sunk.
 * <p>
 * image
 * <p>
 * Given N = 12, S = "1A 2A,12A 12A" and T = "12A", your function should return "1,0", because one
 * ship was hit and sunk.
 * Assume that:
 * <p>
 * N is an integer within the range [1..26];
 * string S contains the descriptions of rectangular ships of area not greater than 4 cells;
 * there can be at most one ship located on any map cell (ships do not overlap);
 * each map cell can appear in string T at most once;
 * string S and string T contains only valid positions given in specified format.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the
 * assessment.
 */

public class Battleship {
  public static void main(String[] args) {
    int N1 = 4;
    String S1 = "1A 1B,2C 2C", T1 = "1B";

    Battleship b = new Battleship();
    System.out.println(b.solution(N1, S1, T1));
  }

  public String solution(int N, String S, String T) {
    if (N <= 0) {
      return "0,0";
    }

    String[] ships = S.split(",");
    String[] attacks = T.split(" ");

    Set<Ship> battleships = new HashSet<>();
    Map<String, Ship> coordinateToBS = new HashMap<>();
    getBattleShips(ships, battleships, coordinateToBS);

    for (String attack : attacks) {
      if (coordinateToBS.containsKey(attack)) {
        Ship ship = coordinateToBS.get(attack);
        ship.hit(attack);
      }
    }

    int sunk = 0;
    int hit = 0;
    for (Ship ship : battleships) {
      if (ship.size == ship.hitSize) {
        sunk++;
      } else if (ship.size > ship.hitSize && ship.hitSize != 0) {
        hit++;
      }
    }

    return sunk + "," + hit;
  }

  private void getBattleShips(String[] b, Set<Ship> battleships, Map<String, Ship> coordinateToBS) {
    for (String shipC : b) {
      Ship ship = new Ship();
      int iStart = shipC.charAt(0) - '0';
      int iStop = shipC.charAt(3) - '0';
      int jStart = shipC.charAt(1);
      int jStop = shipC.charAt(4);
      for (int i = iStart; i <= iStop; i++) {
        for (int j = jStart; j <= jStop; j++) {
          char tmp = (char) j;
          String c = Integer.toString(i) + tmp + "";
          ship.addCoordinate(c);
          coordinateToBS.put(c, ship);
        }
      }
      battleships.add(ship);
    }
  }

  static class Ship {
    List<String> coordinates;
    int size;
    int hitSize;

    Ship() {
      coordinates = new ArrayList<>();
      size = 0;
      hitSize = 0;
    }

    void addCoordinate(String c) {
      coordinates.add(c);
      size++;
    }

    void hit(String c) {
      coordinates.remove(c);
      hitSize++;
    }
  }
}
