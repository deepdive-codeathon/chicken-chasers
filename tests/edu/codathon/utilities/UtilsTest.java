package edu.codathon.utilities;

import static org.junit.jupiter.api.Assertions.*;

import edu.codeathon.utilities.Utils;
import org.junit.jupiter.api.Test;

class UtilsTest {

  @Test
  void parseComment() {
    System.out.println(Utils.parseComment("resources/comments"));
  }
}