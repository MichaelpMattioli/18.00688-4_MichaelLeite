package com.company;

public class RankedNinja extends Ninja {
    protected String mission;
    protected String Rank;

    public void goToMission(){
        System.out.println("Indo para missao: " + mission);
    }

    @Override
    public void train() {
        System.out.println("No pain no gain!");
    }

    public RankedNinja(String name, String family, String mission, String rank) {
        super(name, family);
        this.mission = mission;
        Rank = rank;
    }

    public void listMissions(){
        System.out.println("Missoes Disponiveis para " + this.getName() + " " + this.getFamily() + " :");
        Mission missions = new Mission();
        missions.listAllMissions(this.Rank);
    }
}
