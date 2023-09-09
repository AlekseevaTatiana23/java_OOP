package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println('Hello');
        while (true){
            System.out.println('1. Add person\n' +
                    "2. Get family tree\n" +
                    "3. Sort by name\n" +
                    "4. Sort by age\n" +

        }
    }

    private void addHuman(){
        
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
