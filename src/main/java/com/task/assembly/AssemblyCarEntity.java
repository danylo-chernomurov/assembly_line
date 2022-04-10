package com.task.assembly;

import com.task.assembly.exception.QualityStationPositionException;
import com.task.model.Car;
import com.task.assembly.exception.QualityCheckException;

import java.util.Random;

public class AssemblyCarEntity {

    public static final int QA_CHECK_GATE = 20;
    private boolean isGoodQuality;

    public AssemblyCarEntity(AssemblyCarEntity assemblyCarEntity) {
        this.isGoodQuality = assemblyCarEntity.isGoodQuality;
    }

    public AssemblyCarEntity() {
    }

    public void paint() {
        qaCheckPosition();
        System.out.println("paint");
    }

    public void assemblyMechanic() {
        qaCheckPosition();
        System.out.println("assemblyMechanic");
    }

    public void assemblyInterior() {
        qaCheckPosition();
        System.out.println("assemblyInterior");
    }

    public void polish() {
        qaCheckPosition();
        System.out.println("polish");
    }

    public void qaCheck() {
        var quality = new Random().nextInt(100);
        if (quality < QA_CHECK_GATE) {
            isGoodQuality = false;
            throw new QualityCheckException("Quality check failed");
        }
        isGoodQuality = true;
    }

    public Car build() {
        if (!isGoodQuality) {
            throw new QualityCheckException("Quality check failed");
        }
        return new Car();
    }

    private void qaCheckPosition() {
        if (isGoodQuality) {
            throw new QualityStationPositionException("Quality check should be last. Reconfigure station position");
        }
    }


}
