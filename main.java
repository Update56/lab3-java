import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        pc_builder my_pc = new pc_builder();
        int choice;
        my_pc.input();
        do
        {
            Scanner in = new Scanner(System.in);
            System.out.printf("\n1. List of accessories\n2. Check compatibility\n3. Build evaluation\n4. Recommendations\n5. Set new accessories\n6. Exit\n");
            choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    my_pc.output();
                    break;
                case 2:
                    my_pc.compatibility_check();
                    break;
                case 3:
                    my_pc.score();
                    break;
                case 4:
                    my_pc.recom();
                    break;
                case 5:
                    my_pc.input();
                    break;
                case 6:
                    break;
                default:
                    System.out.printf("Wrong menu item");
                    break;
            }

        } while (choice != 6);

        return;
    }


}
