package com.task;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Station> stations = stationsSetup();

        var assemblyLine = new AssemblyLine(stations);
        assemblyLine.produce(new AssemblyCarEntity());
    }

    private static List<Station> stationsSetup() {
        List<Station> stations = new ArrayList<>();
        stations.add( AssemblyCarEntity::paint);
        stations.add( AssemblyCarEntity::assemblyInterior);
        stations.add( AssemblyCarEntity::assemblyMechanic);
        stations.add( AssemblyCarEntity::polish);
        stations.add( AssemblyCarEntity::qaCheck);
        return stations;
    }
}
