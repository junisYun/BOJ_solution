import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int V, E;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        graph = new int[V + 1][V + 1];
        visited = new boolean[V + 1];
        int start = sc.nextInt();
        for(int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }
        DFS(start);
        System.out.println();
        visited = new boolean[V + 1];
        BFS(start);
    }
    public static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for(int i = 1; i <= V; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for(int i = 1; i <= V; i++) {
                if(graph[x][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
