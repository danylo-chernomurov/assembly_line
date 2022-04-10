package com.task;

import java.util.List;

public class AssemblyLine {

    private final List<Station> stations;

    public Car produce(AssemblyCarEntity assemblyCarEntity) {
        AssemblyCarEntity entity = copyOf(assemblyCarEntity);
        try {
            stations.forEach(x -> x.assemble(entity));
            return entity.build();
        } catch (QualityCheckException e) {
            System.out.println("Quality checks failed");
            return produce(entity);
        }
    }

    public AssemblyLine(List<Station> s) {
        if (s.size() < 2) {
            throw new RuntimeException("Should be at least 2 stations.");
        }
        stations = List.copyOf(s);
    }

    private AssemblyCarEntity copyOf(AssemblyCarEntity assemblyCarEntity) {
        return new AssemblyCarEntity(assemblyCarEntity);
    }

}
