package graphs;

import java.util.*;

/**
    You are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

    Example:

    Given the 2D grid:

    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
    0  -1 INF INF
    After running your function, the 2D grid should be:

    3  -1   0   1
    2   2   1  -1
    1  -1   2  -1
    0  -1   3   4
**/

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}};

        WallsAndGates w = new WallsAndGates();
        rooms = w.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    rooms = computeDistance(i, j, rooms);
                }
            }
        }
        return rooms;
    }

    private int[][] computeDistance(int i, int j, int[][] rooms) {
        Queue<Room> queue = new LinkedList<>();
        int[][] visited = new int[rooms.length][rooms[0].length];
        for (int[] aVisited : visited) {
            Arrays.fill(aVisited, 0);
        }

        int distance = 0;

        Room root = new Room(i, j);
        queue.offer(root);
        visited[i][j] = 1;

        while(!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Room currRoom = queue.peek();
                List<Room> l = getValidAdjacentRooms(currRoom, rooms);
                for (Room r : l) {
                    if (rooms[r.i][r.j] > 0) {
                        if (visited[r.i][r.j] == 0) {
                            if (rooms[r.i][r.j] > distance) rooms[r.i][r.j] = distance;
                            queue.offer(r);
                            visited[r.i][r.j] = 1;
                        }
                    }
                }
                queue.poll();
            }
        }

        return rooms;
    }

    private List<Room> getValidAdjacentRooms(Room currRoom, int[][] rooms) {
        List<Room> l = new ArrayList<>();

        int[] i = {currRoom.i - 1, currRoom.i, currRoom.i, currRoom.i + 1};
        int[] j = {currRoom.j, currRoom.j - 1, currRoom.j + 1, currRoom.j};
        for (int k = 0; k < i.length; k++) {
            if (i[k] >= 0 && i[k] < rooms.length && j[k] >= 0 && j[k] < rooms[0].length) {
                Room r = new Room(i[k],j[k]);
                l.add(r);
            }
        }
        return l;
    }

    class Room {
        int i;
        int j;
        Room(int x, int y) {
            i = x;
            j = y;
        }
    }
}
