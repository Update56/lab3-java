import java.util.Scanner;

public class cpu {

    private int amount_core, power;
    private double clock_rate;
    private String model, socket;

    public cpu(int amount_core, double clock_rate, int power, String model, String socket)
    {
        this.amount_core = amount_core;
        this.clock_rate = clock_rate;
        this.power = power;
        this.model = model;
        this.socket = socket;
    }

    public cpu(int amount_core)
    {
        this.amount_core = amount_core;
    }

    public cpu()
    {
        this.amount_core = 0;
        this.clock_rate = .0;
        this.power = 0;
        this.model = null;
        this.socket = null;
    }

    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the model, socket, number of cores, frequency, and power consumption of the processor (via \"Enter\")\n");
        this.model = in.nextLine();
        this.socket = in.nextLine();
        this.amount_core = in.nextInt();
        this.clock_rate = in.nextDouble();
        this.power = in.nextInt();
    }

    public void output()
    {
        System.out.printf("\nCPU\n\t-model: %s", this.model);
        System.out.printf("\n\t-socket: %s", this.socket);
        System.out.printf("\n\t-amount cores: %d", this.amount_core);
        System.out.printf("\n\t-clock rate: %f", this.clock_rate);
        System.out.printf("\n\t-power consumption: %d", this.power);
    }
    public void set_amount_core(int amount_core)
    {
        this.amount_core = amount_core;
    }

    public void set_clock_rate(double clock_rate)
    {
        this.clock_rate = clock_rate;
    }

    public void set_power(int power)
    {
        this.power = power;
    }

    public void set_model(String model)
    {
        this.model = model;
    }

    public void set_socket(String soket)
    {
        this.socket = soket;
    }

    public int get_amount_core()
    {
        return amount_core;
    }

    public double get_clock_rate()
    {
        return clock_rate;
    }

    public int get_power()
    {
        return power;
    }

    public String get_model()
    {
        return model;
    }

    public String get_socket()
    {
        return socket;
    }
}
