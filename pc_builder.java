public class pc_builder {
    private motherboard Motherboard = new motherboard();
    private cpu Cpu = new cpu();
    private gpu Gpu = new gpu();
    private ram Ram = new ram();
    private psu Psu = new psu();

    private int scoring(int var_Keyword, double amount)
    {
        int[] numbers = {0, 0, 0};
        switch (var_Keyword)
        {
            case 0:
                numbers[0] = 4;
                numbers[1] = 8;
                numbers[2] = 16;
                break;
            case 1:
                numbers[0] = 0;
                numbers[1] = 5;
                numbers[2] = 57;
                break;
            case 2:
                numbers[0] = 12;
                numbers[1] = 50;
                numbers[2] = 105;
                break;
            default:
                break;
        }

        if (amount > numbers[0] && amount <= numbers[1])
        {
            return 1;
        }
        else if (amount > numbers[1] && amount <= numbers[2])
        {
            return 2;
        }
        else if (amount > numbers[2])
        {
            return 3;
        }
        return 0;
    }

    public pc_builder(motherboard Motherboard, cpu Cpu, gpu Gpu, ram Ram, psu Psu)
    {
        this.Motherboard = Motherboard;
        this.Cpu = Cpu;
        this.Gpu = Gpu;
        this.Ram = Ram;
        this.Psu = Psu;
    }
    public pc_builder(motherboard Motherboard)
    {
        this.Motherboard = Motherboard;
    }

    public pc_builder()
    {

    }

    public void input()
    {
        Motherboard.input();
        Cpu.input();
        Gpu.input();
        Ram.input();
        Psu.input();
    }

    public void output()
    {
        Motherboard.output();
        Cpu.output();
        Gpu.output();
        Ram.output();
        Psu.output();
    }

    public void score()
    {
        int total_score = 0;

        double score_cpu = Cpu.get_clock_rate() * Cpu.get_amount_core();
        double score_gpu = (Gpu.get_clock_rate() / 1000.0) * Gpu.get_memory_size() * (Gpu.get_bandwidt() / 100.0);
        double score_ram = (Ram.get_clock_rate() / 1000.0) * Ram.get_memory_size();

        total_score += scoring(0, score_cpu);
        total_score += scoring(1, score_gpu);
        total_score += scoring(2, score_ram);

        if (total_score <= 2)
        {
            System.out.printf("This is a VERY weak PC.");
        }
        else if (total_score > 2 && total_score < 6)
        {
            System.out.printf("It's a weak PC.");
        }
        else if (total_score >= 6 && total_score < 9)
        {
            System.out.printf("It's a good, powerful PC.");
        }
        else if (total_score >= 9)
        {
            System.out.printf("It's the most powerful PC");
        }

    }

    public void recom()
    {
        double score_cpu = Cpu.get_clock_rate() * Cpu.get_amount_core();
        double score_gpu = (Gpu.get_clock_rate() / 1000.0) * Gpu.get_memory_size() * (Gpu.get_bandwidt() / 100.0);
        double score_ram = (Ram.get_clock_rate() / 1000.0) * Ram.get_memory_size();

        int f_score_cpu = scoring(0, score_cpu);
        int f_score_gpu = scoring(1, score_gpu);
        int f_score_ram = scoring(2, score_ram);

        if ((f_score_cpu > f_score_gpu) && (f_score_cpu > f_score_ram))
        {
            System.out.printf("The processor is too powerful. It is recommended to choose another or more powerful video card and RAM");
            return;
        }

        if ((f_score_cpu < f_score_gpu) && (f_score_gpu > f_score_ram))
        {
            System.out.printf("The video card is too powerful. It is recommended to choose another or more powerful processor and RAM");
            return;
        }

        if ((f_score_cpu < f_score_ram) && (f_score_gpu < f_score_ram))
        {
            System.out.printf("Too much memory. It is recommended to choose another or more powerful processor and video card");
            return;
        }

        System.out.printf("Your assembly is balanced");
        return;
    }

    public void compatibility_check()
    {
        if (Motherboard.get_socket().equals(Cpu.get_socket())) {
            System.out.printf("Processor and motherboard are compatible\n");
        } else {
            System.out.printf("Processor and board sockets are different!\n");
        }
        if (Motherboard.get_type_memory().equals(Ram.get_type_memory())) {
            System.out.printf("The motherboard and RAM are compatible\n");
        } else {
            System.out.printf("The memory type of the motherboard and the RAM are different!\n");
        }
        if ((Cpu.get_power() + Gpu.get_power()) < Psu.get_power()) {
            System.out.printf("The power of the PSU is enough (about %d watts to spare)\n", (Psu.get_power() - (Cpu.get_power() + Gpu.get_power())));
        } else {
            System.out.printf("Weak PSU, not enough %d watts\n", (Cpu.get_power() + Gpu.get_power()) - Psu.get_power());
        }
    }
}

