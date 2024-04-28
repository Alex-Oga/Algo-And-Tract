import java.util.*;
import java.util.stream.Collectors;

public class RealEstate {

    static int realEstateBroker(int[][] clients, int[][] houses) {
        int sold = 0;
        Arrays.sort(houses, Comparator.comparingDouble(o -> o[0]));

        for (int i=houses.length-1; i>=0; i--) {
            int[] check = {0, 0};
            int index = -1;
            for (int j=0; j<clients.length; j++) {
                if (clients[j][1] == 0)
                    continue;
                if (houses[i][0] > clients[j][0] && houses[i][1] <= clients[j][1] && check[0] == 0) {
                    check[0] = houses[i][0];
                    check[1] = houses[i][1];
                    index = j;
                }
                else if(houses[i][0] < check[0] && clients[j][1] >= houses[i][1] && houses[i][0] > clients[j][0]) {
                    check[0] = houses[i][0];
                    check[1] = houses[i][1];
                    index = j;
                }
            }
            if (index != -1) {
                sold++;
                clients[index][1] = 0;
            }
        }


        return sold;
    }

    public static void main(String[] args) {
        int[][] client = {{100,100}, {5, 110}, {9, 500}, {20, 400}, {1000, 100}};
        int[][] house = {{10, 100}, {2, 200}, {30, 300}};

        System.out.println(realEstateBroker(client, house));
    }
}
