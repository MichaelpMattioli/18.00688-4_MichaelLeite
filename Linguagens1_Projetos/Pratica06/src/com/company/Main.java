package com.company;

public class Main {

    public static void main(String[] args) {
        Ninja ninja = new Ninja("Naruto", "Uzumaki");
        ninja.train();
        AcademicStudent academicStudent = new AcademicStudent("Sasuke","Uchiha");
        mostrarTreino(academicStudent);
        Chuunin chuunin = new Chuunin("Iruka", "Umino", "Treinar o estilo madeira.");
        mostrarTreino(chuunin);
        chuunin.goToMission();
        Jounin jounin = new Jounin("Kakashi","Hatake", "Treinar com o Guy.");
        SpecialJounin specialJounin = new SpecialJounin("Ibiki", "Morino", "");
        Genin genin = new Genin("Sakura", "Haruno", "");
        mostrarTreino(jounin);

        genin.listMissions();
        chuunin.listMissions();
        specialJounin.listMissions();
        jounin.listMissions();

    }

    static void mostrarTreino(Ninja ninja){
        ninja.train();
    }
}
