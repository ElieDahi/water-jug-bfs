public class App {
    public static void main(String[] args) {
        WaterJug game = new WaterJug(7, 5, 2);
        new BFS(game).search();
    }
}