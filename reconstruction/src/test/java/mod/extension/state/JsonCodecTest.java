package mod.extension.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JsonCodecTest {
  @Test
  void roundTripsNestedUtf8EscapesAndNumbers() {
    Map<String, Object> source = new LinkedHashMap<String, Object>();
    source.put("club", "S\u00e3o \"Paulo\"\nFC");
    source.put("active", Boolean.TRUE);
    source.put("points", Integer.valueOf(72));
    source.put("ratio", Double.valueOf(1.5D));
    source.put("items", Arrays.asList("one", null, Boolean.FALSE));

    String json = JsonCodec.write(source);
    Object restored = JsonCodec.parse(json);

    assertTrue(restored instanceof Map);
    @SuppressWarnings("unchecked")
    Map<String, Object> object = (Map<String, Object>)restored;
    assertEquals("S\u00e3o \"Paulo\"\nFC", object.get("club"));
    assertEquals(Long.valueOf(72L), object.get("points"));
    assertEquals(Double.valueOf(1.5D), object.get("ratio"));
  }

  @Test
  void rejectsAmbiguousOrMalformedJson() {
    assertThrows(IllegalArgumentException.class,
        () -> JsonCodec.parse("{\"x\":1,\"x\":2}"));
    assertThrows(IllegalArgumentException.class,
        () -> JsonCodec.parse("{\"x\":01}"));
    assertThrows(IllegalArgumentException.class,
        () -> JsonCodec.parse("[true,]"));
    assertThrows(IllegalArgumentException.class,
        () -> JsonCodec.write(new Object()));
  }
}
