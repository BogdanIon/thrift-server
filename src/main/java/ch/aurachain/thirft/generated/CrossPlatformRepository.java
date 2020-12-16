package ch.aurachain.thirft.generated;

import java.util.Map;

public class CrossPlatformRepository {

    private final Map<Integer, CrossPlatformResource> crossMap;

    public CrossPlatformRepository(Map<Integer, CrossPlatformResource> crossPlatformResourceMap) {
        this.crossMap = crossPlatformResourceMap;
    }

    public CrossPlatformResource getCourse(int id) {
        return crossMap.get(id);
    }
}
