package com.codeassigements.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeassigements.dto.SimpleProbeInput;
import com.codeassigements.model.Grid;
import com.codeassigements.model.Probe;
import com.codeassigements.services.ProbeService;

@RestController
@RequestMapping("/api/probe")
public class ProbesController {
	@Autowired
	private ProbeService probeService;

	public ProbesController(ProbeService probeService) {
		this.probeService = probeService;
	}

	@PostMapping("/execute")
	public Probe execute(@RequestBody SimpleProbeInput input) {
		Grid grid = new Grid(input.getGridHeight(), input.getGridWidth(), input.getObstacles());
		Probe probe = new Probe(input.getStartX(), input.getStartY(), input.getStartDirections());
		return probeService.execute(grid, probe, input.getCommands());
	}

}
