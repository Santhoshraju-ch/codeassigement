package com.codeassigement.controller;

import com.codeassigement.model.Intersection;
import com.codeassigement.model.LightStateHistory;
import com.codeassigement.services.TrafficLightService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/intersections")
public class TrafficLightController {

    private final TrafficLightService service;

    public TrafficLightController(TrafficLightService service) {
        this.service = service;
    }

    @GetMapping("/{id}/state")
    public Map<?, ?> getState(@PathVariable String id) {
        Intersection intersection = service.getOrCreateIntersection(id);
        return intersection.getLights();
    }

    @GetMapping("/{id}/history")
    public List<LightStateHistory> getHistory(@PathVariable String id) {
        Intersection intersection = service.getOrCreateIntersection(id);
        return intersection.getHistory();
    }

    @PostMapping("/{id}/pause")
    public void pause(@PathVariable String id) {
        service.pause(id);
    }

    @PostMapping("/{id}/resume")
    public void resume(@PathVariable String id) {
        service.resume(id);
    }
}
