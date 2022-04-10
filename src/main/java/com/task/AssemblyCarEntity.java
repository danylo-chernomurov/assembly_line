package com.task;

import java.util.Random;

public class AssemblyCarEntity {

    private boolean isGoodQuality;

    public AssemblyCarEntity(AssemblyCarEntity assemblyCarEntity) {
        this.isGoodQuality = assemblyCarEntity.isGoodQuality;
    }

    public AssemblyCarEntity() {
    }

    public AssemblyCarEntity paint() {
        if (isGoodQuality) {
            throw new RuntimeException("Quality check should be last");
        }
        System.out.println("paint");
        return this;
    }

    public AssemblyCarEntity assemblyMechanic() {
        if (isGoodQuality) {
            throw new RuntimeException("Quality check should be last");
        }
        System.out.println("assemblyMechanic");
        return this;
    }

    public AssemblyCarEntity assemblyInterior() {
        if (isGoodQuality) {
            throw new RuntimeException("Quality check should be last");
        }
        System.out.println("assemblyInterior");
        return this;
    }

    public AssemblyCarEntity qaCheck() {
        var quality = new Random().nextInt(100);
        if (quality < 80) {
            isGoodQuality = false;
            throw new QualityCheckException("Quality check failed");
        }
        isGoodQuality = true;
        return this;
    }

    public Car build() {
        if (!isGoodQuality) {
            throw new QualityCheckException("Quality check failed");
        }
        return new Car();
    }

}
