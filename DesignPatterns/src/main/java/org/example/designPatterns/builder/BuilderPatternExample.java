package org.example.designPatterns.builder;

// 1. Product (Complex Object)
class House {
    private final int windows;
    private final int doors;
    private final boolean hasGarage;
    private final boolean hasGarden;

    // Private Constructor
    private House(HouseBuilder builder) {
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
    }

    @Override
    public String toString() {
        return "House [windows=" + windows + ", doors=" + doors +
                ", hasGarage=" + hasGarage + ", hasGarden=" + hasGarden + "]";
    }

    // 2. Builder Class (Static Nested)
    public static class HouseBuilder {
        private int windows;
        private int doors;
        private boolean hasGarage;
        private boolean hasGarden;

        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Build method to return final object
        public House build() {
            return new House(this);
        }
    }
}

// 3. Usage
public class BuilderPatternExample {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .setWindows(4)
                .setDoors(2)
                .setGarage(true)
                .setGarden(true)
                .build();

        System.out.println(house);
    }
}
