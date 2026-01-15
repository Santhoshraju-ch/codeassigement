package com.codeassigement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeassigement.enu.Direction;
import com.codeassigement.enu.LightColor;
import com.codeassigement.model.Intersection;

@SpringBootTest
class CodeassigementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void conflictingDirectionsShouldNeverBeGreen() {
		Intersection intersection = new Intersection();
		for (int i = 0; i < 10; i++) {
			intersection.advance();
			boolean nsGreen = intersection.getLights().get(Direction.NORTH).getColor() == LightColor.GREEN;
			boolean ewGreen = intersection.getLights().get(Direction.EAST).getColor() == LightColor.GREEN;
			assertFalse(nsGreen && ewGreen);
		}
	}

	@Test
	public void pausedIntersectionShouldNotAdvance() {
		Intersection i = new Intersection();
		i.pause();
		LightColor before = i.getLights().get(Direction.NORTH).getColor();
		i.advance();
		assertEquals(before, i.getLights().get(Direction.NORTH).getColor());
	}

}
