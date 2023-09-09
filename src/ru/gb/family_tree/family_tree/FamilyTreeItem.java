package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T>{
    String getName();
    int getAge();
    void setDateBirthday(LocalDate dateBirthday);
    void setId(long id);
    long getId();
    List<T> getParents();
    void addParents(T human);
    List<T> getChildren();
    void addChild(T child);
    Human getSpouse();
    void setSpouse(T human);
    Gender getGender();
    void setGender(Gender gender);
    LocalDate getDateBirthday();
    LocalDate getDateDeath();
    boolean addSiblings(T human);
    List<T> getSiblings();
    T getFather();
    T getMother();

}
