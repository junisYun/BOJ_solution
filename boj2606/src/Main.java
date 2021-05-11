import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int V, E;
    static int[][] virus;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        virus = new int[V + 1][V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            virus[x][y] = virus[y][x] = 1;
        }
        System.out.println(DFS(1));
        answer = 0;
        visited = new boolean[V + 1];
        System.out.println(BFS(1));
    }

    public static int DFS(int start) {
        visited[start] = true;
        for(int i = 1; i <= V; i++) {
            if(virus[start][i] == 1 && !visited[i]) {
                answer++;
                DFS(i);
            }
        }
        return answer;
    }
    public static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= V; i++) {
                if (virus[x][i] == 1 && !visited[i]) {
                    answer++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return answer;
    }
}
