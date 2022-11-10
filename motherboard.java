import java.util.Scanner;

public class motherboard
{
    private String model, socket, type_memory;

    public motherboard(String model, String socket, String type_memory)
    {
        this.model = model;
        this.socket = socket;
        this.type_memory = type_memory;
    }

    public motherboard(String socket)
    {
        this.socket = socket;
    }

    public motherboard()
    {
        this.model = null;
        this.socket = null;
        this.type_memory = null;
    }

    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter motherboard model, socket and memory type (via \"Enter\")\n");
        this.model = in.nextLine();
        this.socket = in.nextLine();
        this.type_memory = in.nextLine();
    }

    public void output() {
        System.out.printf("\nMotherboard\n\t-model: %s", this.model);
        System.out.printf("\n\t-socket: %s", this.socket);
        System.out.printf("\n\t-memory type: %s", this.type_memory);
    }

    public void set_model(String model)
    {
        this.model = model;
    }

    public void set_socket(String socket)
    {
        this.socket = socket;
    }

    public void set_type_memory(String type_memory)
    {
        this.type_memory = type_memory;
    }

    public String get_model()
    {
        return model;
    }

    public String get_socket()
    {
        return socket;
    }

    public String get_type_memory()
    {
        return type_memory;
    }
}
