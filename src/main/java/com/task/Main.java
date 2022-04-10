package com.task;

import com.task.assembly.AssemblyCarEntity;
import com.task.assembly.AssemblyLine;
import com.task.assembly.Station;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var stations = stationsSetup();
        var assemblyLine = new AssemblyLine(stations);
        assemblyLine.produce(new AssemblyCarEntity());
    }

    private static List<Station> stationsSetup() {
        var stations = new ArrayList<Station>();
        stations.add(AssemblyCarEntity::paint);
        stations.add(AssemblyCarEntity::assemblyInterior);
        stations.add(AssemblyCarEntity::assemblyMechanic);
        stations.add(AssemblyCarEntity::polish);
        stations.add(AssemblyCarEntity::qaCheck);
        return stations;
    }
}
