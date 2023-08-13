package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.save.FileHandler;

import java.net.HttpRetryException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/ru.gb.family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = new FamilyTree();
        fileHandler.save(familyTree, filePath);

        //FileHandler fileHandler = new FileHandler();
        //FamilyTree familyTree = (FamilyTree) fileHandler.read((filePath));
        // System.out.println(familyTree);


        Human irina = new Human("Alekseeva Irina", Gender.Female, LocalDate.of(1972, 9, 26));
        Human sasha = new Human("Alekseev Aleksandr", Gender.Female, LocalDate.of(1969, 12, 24));

        familyTree.addHuman(irina);
        familyTree.addHuman(sasha);
        irina.setSpouse(sasha);
        //familyTree.setWedding(sasha, irina);

        Human tanya = new Human("Alekseeva Tatiana", Gender.Female, LocalDate.of(1994, 8, 23));
        Human nadya = new Human("Alekseeva Nadezda", Gender.Female, LocalDate.of(1991, 11, 9));
        familyTree.addHuman(tanya);
        familyTree.addHuman(nadya);

        irina.addChild(tanya);
        irina.addChild(nadya);
        sasha.addChild(tanya);
        sasha.addChild(nadya);
        //tanya.addParents(sasha);
        //tanya.addParents(irina);

        System.out.println(irina.getSpouse());
        System.out.println(tanya.getName());
        System.out.println(sasha.getChildren());
        System.out.println(nadya.getInfo());
        System.out.println(familyTree.getInfo());

        public void sortByName(){
            familyTree.sortByName();
        }
        System.out.println(familyTree.sortByName());
        //System.out.println(tanya.getFather());
    }
}
//TODO не работает метод setWedding, getParents, getFather, getMother. Где ошибка? Сохранение не работает?