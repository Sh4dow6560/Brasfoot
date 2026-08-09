package com.brasfoot.reconstruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DifferentialTestServiceTest {
  @Test
  void parsesScenarioAndPerClassCountMarkers() {
    Map<String, String> markers = DifferentialTestService.parseMarkers(String.join("\n",
        "diagnostic line ignored",
        "COUNT best.A 3116",
        "COUNT best.F 18987",
        "CALENDAR days=365 matches=2312",
        "ROUNDTRIP originalBytes=10 outputBytes=10 byteIdentical=true"));

    assertEquals(4, markers.size());
    assertEquals("COUNT best.A 3116", markers.get("COUNT best.A"));
    assertEquals("CALENDAR days=365 matches=2312", markers.get("CALENDAR"));
  }

  @Test
  void reportsMissingAndChangedMarkers() {
    List<DifferentialTestService.ScenarioComparison> comparisons =
        DifferentialTestService.compare(
            Map.of("CALENDAR", "CALENDAR matches=10", "ROOT", "ROOT best.f"),
            Map.of("CALENDAR", "CALENDAR matches=11", "ROUNDTRIP", "ROUNDTRIP ok"));

    assertEquals(3, comparisons.size());
    assertFalse(comparisons.get(0).identical());
    assertTrue(comparisons.stream().anyMatch(
        result -> result.id().equals("ROOT") && result.hybrid() == null));
    assertTrue(comparisons.stream().anyMatch(
        result -> result.id().equals("ROUNDTRIP") && result.original() == null));
  }
}
