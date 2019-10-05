package edu.codeathon.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilsTest {

  @Test
  void hash() {
    assertEquals("dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f",Utils.hash("Hello, World!"));

  }
}