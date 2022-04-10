package com.task;

import java.util.Random;

public class AssemblyCarEntity {

    public static final int QA_CHECK_GATE = 20;
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

    public AssemblyCarEntity polish() {
        if (isGoodQuality) {
            throw new RuntimeException("Quality check should be last");
        }
        System.out.println("polish");
        return this;
    }

    public AssemblyCarEntity qaCheck() {
        var quality = new Random().nextInt(100);
        if (quality < QA_CHECK_GATE) {
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
