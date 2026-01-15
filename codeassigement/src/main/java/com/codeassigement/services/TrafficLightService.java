package com.codeassigement.services;

import com.codeassigement.model.Intersection;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

@Service
public class TrafficLightService {

    private final Map<String, Intersection> intersections = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public TrafficLightService() {
        scheduler.scheduleAtFixedRate(this::advanceAll, 0, 5, TimeUnit.SECONDS);
    }

    private void advanceAll() {
        intersections.values().forEach(Intersection::advance);
    }

    public Intersection getOrCreateIntersection(String id) {
        return intersections.computeIfAbsent(id, k -> new Intersection());
    }

    public void pause(String id) {
        getOrCreateIntersection(id).pause();
    }

    public void resume(String id) {
        getOrCreateIntersection(id).resume();
    }
}
